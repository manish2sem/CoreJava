package CoreJava.J_Advance.Reflection.Z__DemoClass;

import java.util.List;
import java.util.Map;

public class DemoClassforGenerics {
	
	public List<String> stringList = null;
	public Map<String, Integer> mapList = null;
	
	public List<String> getStringList(List<String> list, int x)
	{
		this.stringList = list;
	    return this.stringList;
	}

	public List<String> getStringList()
	{
	    return this.stringList;
	}
	
	public Map<String, Integer> getMapList()
	{
	    return this.mapList;
	}

}
