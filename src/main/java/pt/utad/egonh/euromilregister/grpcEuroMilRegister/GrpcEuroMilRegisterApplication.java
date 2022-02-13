package pt.utad.egonh.euromilregister.grpcEuroMilRegister;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import euromilClient.EuromilGrpc;
import euromilClient.RegisterReply;
import euromilClient.RegisterRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
@SpringBootApplication
public class GrpcEuroMilRegisterApplication {
	public static void main(String[] args) {
		SpringApplication.run(GrpcEuroMilRegisterApplication.class, args);
	}
}
