package com.awsjavalambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification.S3EventNotificationRecord;

public class AddressS3Handler implements RequestHandler<S3Event, String> {

	@Override
	public String handleRequest(S3Event event, Context context) {
		StringBuffer buffer = new StringBuffer();
		int c = 0;

		S3EventNotificationRecord record = event.getRecords().get(0);
		String bucketName = record.getS3().getBucket().getName();
		String objectName = record.getS3().getObject().getUrlDecodedKey();

//		AmazonS3 client = new AmazonS3Client();
//		S3Object xFile = client.getObject(bucketName, objectName);
//		InputStream contents = xFile.getObjectContent();
//		try {
//			while ((c = contents.read()) != -1) {
//				buffer.append((char) c);
//			}
//		} catch (IOException e) {
//			context.getLogger().log("error: " + e.getMessage());
//		}
		context.getLogger().log("bucketName:" + bucketName);
		context.getLogger().log("objectName:" + objectName);
		buffer.append(objectName);
		return buffer.toString();
	}

}
