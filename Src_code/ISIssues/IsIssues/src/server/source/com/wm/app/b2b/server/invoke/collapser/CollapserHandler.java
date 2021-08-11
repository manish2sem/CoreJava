package com.wm.app.b2b.server.invoke.collapser;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.wm.app.b2b.server.BaseService;
import com.wm.app.b2b.server.invoke.ServiceStatus;
import com.wm.data.IData;
import com.wm.data.IDataUtil;

public class CollapserHandler {

	private static Map<Holder, Collapser> map = new ConcurrentHashMap<>();

	private static long requests;

	private static long served;

	public static IData handle(Iterator chain, BaseService se, IData pipeline, ServiceStatus status) {

		Holder holder = new Holder(se.getNSName().getFullName(), pipeline);
		
		try {
			synchronized (map) {
				requests++;
				if (map.get(holder) == null || map.get(holder).isStopped()) {
					served++;
					IData sample = IDataUtil.deepClone(pipeline);
					holder.pipeline = sample;
					map.put(holder, new Collapser());
				}
			}
		} catch (Exception e) {

		}

		System.out.println("Requests - " + requests + " served- " + served);

		return map.get(holder).collapse(chain, se, pipeline, status);

	}

	static class Holder {
		private String namespace;
		private IData pipeline;
		private String pipelineAsString;

		public Holder(String namespace, IData pipeline) {
			this.namespace = namespace;
			this.pipeline = pipeline;
			if (pipeline != null)
				pipelineAsString = pipeline.toString();

		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((pipelineAsString == null) ? 0 : pipelineAsString.hashCode());
			result = prime * result + ((namespace == null) ? 0 : namespace.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Holder other = (Holder) obj;
			if (pipeline == null) {
				if (other.pipeline != null)
					return false;
			} else if (!pipelineAsString.equals(other.pipelineAsString))
				return false;
			if (namespace == null) {
				if (other.namespace != null)
					return false;
			} else if (!namespace.equals(other.namespace))
				return false;
			return true;
		}

	}

}
