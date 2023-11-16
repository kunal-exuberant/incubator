package likedriving.TechStacks.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

import java.util.List;

public class CassandraDemo {

    private Session session;



    public void connect(){
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        this.session = cluster.connect("bottomup");
        System.out.println("Connected to cassandra");
    }

    public void select(){
        String query = "select * from emp limit 10";
        System.out.println("Executing the query");
        ResultSet resultset = session.execute(query);
        resultset.iterator().forEachRemaining(System.out::println);
    }

    public void insert(){
        String query = "insert into emp(empid, empname, dept, sal) values(2, 'khushboo', 'managing', 2000)";
        this.session.execute(query);
    }


    public static void main(String[] args) {

        List<String> x = null;
        if(x.isEmpty()){
            System.out.println("is null");
            return;
        }
        System.out.println("not null");

        CassandraDemo demo = new CassandraDemo();
        demo.connect();
        demo.insert();
        demo.select();
    }
}
