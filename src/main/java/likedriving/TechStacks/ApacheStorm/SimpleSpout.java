package likedriving.TechStacks.ApacheStorm;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichSpout;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;

class SimpleSpout implements IRichSpout {

    SpoutOutputCollector spoutOutputCollector;
    TopologyContext topologyContext;


    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        this.spoutOutputCollector = collector;
        this.topologyContext = context;
    }

    @Override
    public void close() {
        System.out.println("Pending count 1");
        spoutOutputCollector.getPendingCount();
        System.out.println("Pending count 2");

    }

    @Override
    public void activate() {

    }

    @Override
    public void deactivate() {

    }

    @Override
    public void nextTuple() {
        Random random = new Random();
        String [] names = {"Kunal", "Kundan", "Manoj", "Vikas", "Ankit", "Akhil"};
        String value = names[random.nextInt(names.length-1)];
        spoutOutputCollector.emit(Arrays.asList(value));
    }

    @Override
    public void ack(Object msgId) {
        spoutOutputCollector.emit(Arrays.asList("Kunal"));

    }

    @Override
    public void fail(Object msgId) {

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
