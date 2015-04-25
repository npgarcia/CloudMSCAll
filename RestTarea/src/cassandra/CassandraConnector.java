package cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

import static java.lang.System.out;

/**
 * Class used for connecting to Cassandra database.
 */
public class CassandraConnector {
	/** Cassandra Cluster. */
	private Cluster cluster;
	/** Cassandra Session. */
	private Session session = null;

	/**
	 * Connect to Cassandra Cluster specified by provided node IP address and
	 * port number.
	 * 
	 * @param node
	 *            Cluster node IP address.
	 * @param port
	 *            Port of cluster host.
	 */
	public void connect(String keyspace) {

		String node = "";
		int port = 0;

		node = "54.165.43.110";
		port = 9042;

		if (session == null) {
			System.out.println("Data for DEBUG: " + node + ":" + port
					+ " keyspace " + keyspace);
			this.cluster = Cluster.builder().addContactPoint(node)
					.withPort(port).build();
			session = cluster.connect();
			final Metadata metadata = cluster.getMetadata();
			out.printf("Connected to cluster: %s\n", metadata.getClusterName());
			for (final Host host : metadata.getAllHosts()) {
				out.printf("Datacenter: %s; Host: %s; Rack: %s\n",
						host.getDatacenter(), host.getAddress(), host.getRack());
			}
			session.execute("USE " + keyspace +";");
		}
	}

	/**
	 * Provide my Session.
	 * 
	 * @return My session.
	 */

	public Session getSession() {
		return this.session;
	}

	/** Close cluster. */
	public void close() {
		cluster.close();
	}

	public ResultSet execute(String query) {
		return this.session.execute(query);
	}
}