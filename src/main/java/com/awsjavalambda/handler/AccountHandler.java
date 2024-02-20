package com.awsjavalambda.handler;

import java.security.SecureRandom;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class AccountHandler implements RequestHandler<String, String> {
	private final String[] names = { "James", "Paul", "Anderson", "Peter", "Alex" };

	@Override
	public String handleRequest(String input, Context context) {
		context.getLogger().log("received request with input: " + input);
		return names[new SecureRandom().nextInt(4)];
	}

}
