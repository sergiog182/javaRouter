package com.builder;

import org.apache.camel.builder.RouteBuilder;

public class RouteBuilderBean extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:{{xmlincoming}}")
		.doTry()
			.setHeader("orderId", xpath("/order/id/text()"))
			.setHeader("countryCode", xpath("/order/country/text()"))
			.process(new com.processors.FileProcessor())
			.choice()
				//Using java functions
				.when(header("countryCode").isEqualTo("CO"))
				.to("file:{{outgoingcolombia}}?fileExist=Fail")
				
				//using simple declaration
				.when(simple("${headers.countryCode} == 'US'"))
				.to("file:{{outgoingeu}}?fileExist=Fail")
			
				//using xpath expresion
				.when(xpath("/order/country/text() = 'UK'"))
				.to("file:{{outgoinguk}}?fileExist=Fail")
			
				.otherwise()
				.to("file:{{outgoingother}}?fileExist=Fail")
			.end()
		.endDoTry()
		.doCatch(Exception.class)
			.to("file:{{outgoingerror}}?fileExist=Append")
		.end();
		
	}

}
