package msc.ws.repositoryEndpoint;

import javax.xml.ws.Endpoint;

import msc.ws.repositoryServer.RepositoryImpl;

public class RepositoryPublisher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endpoint.publish("http://localhost:1234/Repository", new RepositoryImpl());
	}

}
