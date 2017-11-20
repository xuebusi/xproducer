package xproducer.common.result;

/**
 * 消息的位置元数据
 * Created by SYJ on 2017/11/20.
 */
public class SendRecord {

    private String topic;
    private int partition;
    private long offset;

    public SendRecord(){

    }

    public SendRecord(String topic, int partition, long offset) {
        this.topic = topic;
        this.partition = partition;
        this.offset = offset;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getPartition() {
        return partition;
    }

    public void setPartition(int partition) {
        this.partition = partition;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }
}
