package pt.utad.egonh.euromilregister.grpcEuroMilRegister;



import euromilClient.EuromilGrpc;
import euromilClient.RegisterReply;
import euromilClient.RegisterRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcEuroMilRegisterApplication {

	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("ken.utad.pt", 8282).usePlaintext().build();
		
		EuromilGrpc.EuromilBlockingStub stub = EuromilGrpc.newBlockingStub(channel);
		
		RegisterReply regReply = stub.registerEuroMil(RegisterRequest.newBuilder().setKey("1 2 3 4 5 6 7").setCheckid("5344200841105540").build());
		
		System.out.println(regReply.getMessage());
		
		channel.shutdown();
	}

}
