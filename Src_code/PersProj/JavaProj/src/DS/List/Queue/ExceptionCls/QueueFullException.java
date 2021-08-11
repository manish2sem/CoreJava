package DS.List.Queue.ExceptionCls;

public class QueueFullException extends RuntimeException{
	
	public QueueFullException (String msg) {
		super(msg);
	}
	
	QueueFullException () {
		super();
	}

}
