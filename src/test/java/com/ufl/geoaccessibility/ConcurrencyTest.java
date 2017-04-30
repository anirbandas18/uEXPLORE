package com.ufl.geoaccessibility;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

import javax.management.ObjectName;

public class ConcurrencyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime runtime = Runtime.getRuntime();
		int cores = runtime.availableProcessors();
		System.out.println(cores);
		OperatingSystemMXBean mxBean = ManagementFactory.getOperatingSystemMXBean() ;
		ObjectName om = mxBean.getObjectName();
		double load = mxBean.getSystemLoadAverage();
		System.out.println(om);
		System.out.println(load);
	}

}
