package EffectiveJava.A_Objects.Item1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collections;

import EffectiveJava.A_Objects.Item1.Provider;


public class Services {
	private Services() { } // Prevents instantiation (Item 4)
	// Maps service names to services
	private static final Map<String, Provider> providers = 
			new ConcurrentHashMap<String, Provider>();
	//Map<String, String> myImmutableMap = Collections.unmodifiableMap(providers);
	Map<String, Provider> myImmutableMap = Collections.unmodifiableMap(providers);


	public static final String DEFAULT_PROVIDER_NAME = "<def>";
	
	//Provider registration API
	public static void registerDefaultProvider(Provider p) {
		registerProvider(DEFAULT_PROVIDER_NAME, p);
	}
	
	public static void registerProvider(String name, Provider p){
		providers.put(name, p);
	}
	
	//Service access API
	public static Service newInstance() {
		return newInstance(DEFAULT_PROVIDER_NAME);
	}
	
	public static Service newInstance(String name) {
		Provider p = providers.get(name);
		if (p == null)
			throw new IllegalArgumentException(
					"No provider registered with name: " + name);
		return p.newService();
	}
}

//Service provider interface
interface Provider {
	Service newService();
}

interface Service {
}