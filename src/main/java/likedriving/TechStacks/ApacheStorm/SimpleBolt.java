package likedriving.TechStacks.ApacheStorm;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;

import java.util.Map;

public class SimpleBolt implements IRichBolt {

    OutputCollector outputCollector;
    TopologyContext topologyContext;

    @Override
    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {

        this.outputCollector = collector;
        this.topologyContext = context;
    }

    @Override
    public void execute(Tuple input) {

        //input.getValueByField();

        System.out.println("Receiving tuples in the bolt");

        System.out.println(input.getMessageId());

    }

    @Override
    public void cleanup() {

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields());
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}
