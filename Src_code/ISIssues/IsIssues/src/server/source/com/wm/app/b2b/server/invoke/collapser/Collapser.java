package server.source.com.wm.app.b2b.server.invoke.collapser;


import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

import com.wm.app.b2b.server.BaseService;
import com.wm.app.b2b.server.invoke.InvokeManager;
import com.wm.app.b2b.server.invoke.ServiceStatus;
import com.wm.data.IData;
import com.wm.data.IDataFactory;
import com.wm.data.IDataUtil;

public class Collapser {

	private Object lock = new Object();
	private CountDownLatch latch = new CountDownLatch(1);
	private State state = State.NEW;
	private IData result = IDataFactory.create();

	private static AtomicLong id = new AtomicLong();

	private long current_id;

	public Collapser() {
		current_id = id.incrementAndGet();
	}

	public IData collapse(Iterator chain, BaseService se, IData pipeline, ServiceStatus status) {

		try {

			if (state == State.STOPPED) {
				System.out.println("Collapser - Skipped old collapser with id - " + current_id);
				return CollapserHandler.handle(chain, se, pipeline, status);
			}

			synchronized (lock) {

				if (state == State.NEW) {

					System.out.println("Collapser - State is new - " + current_id);

					TimerTask task = new UnlockTask(this);

					Timer timer = new Timer();
					timer.schedule(task, 5000);

					state = State.RUNNING;

					latch.await();

				}

				if (state == State.RUNNING) {

					System.out.println("Collapser - State is RUNNING - " + current_id);

					status.setFromCollapser(true);

					result = InvokeManager.getDefault().invokeAndGetOutput(chain, se, pipeline, status);

					state = State.STOPPED;

					// return result;

				}

				IDataUtil.merge(result, pipeline);

				return pipeline;

			}
		} catch (Exception e) {
			e.printStackTrace();
			return pipeline;
		}

	}

	public void timeUp() {

		latch.countDown();

	}

	public boolean isStopped() {
		return this.state == State.STOPPED;
	}

	class UnlockTask extends TimerTask {
		private Collapser c;

		public UnlockTask(Collapser c) {
			this.c = c;
		}

		@Override
		public void run() {
			c.timeUp();
		}
	}

	enum State {
		NEW, STOPPED, RUNNING
	}
}
