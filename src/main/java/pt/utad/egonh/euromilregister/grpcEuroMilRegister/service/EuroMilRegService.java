package pt.utad.egonh.euromilregister.grpcEuroMilRegister.service;

import org.springframework.stereotype.Service;

import euromilClient.EuromilGrpc;
import euromilClient.RegisterReply;
import euromilClient.RegisterRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Service
public class EuroMilRegService {

	private final String URL = "ken.utad.pt";
	private final int PORT = 8282;
	
	
	public String registerEuroMil(String keyGame, String checkId) {
		ManagedChannel channel = null;
		try {
			//Create a channel to host
			channel = ManagedChannelBuilder.forAddress(URL, PORT).usePlaintext().build();
			//Needs to create a new stub to deal the connection
			EuromilGrpc.EuromilBlockingStub stub = EuromilGrpc.newBlockingStub(channel);
			//Call the service and the response comes to generated class of response
			RegisterReply regReply = stub.registerEuroMil(RegisterRequest.newBuilder().setKey(keyGame).setCheckid(checkId).build());
			
			return regReply.getMessage();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			channel.shutdown();			
		}
		
		return "";

	}
}
