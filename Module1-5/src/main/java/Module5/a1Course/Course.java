package Module5.a1Course;



import java.io.Serializable;


public class Course  {
    private int id;
    private String topic;
    private String author;

    public Course ( int id, String topic, String author ) {
        this.id = id;
        this.topic = topic;
        this.author = author;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public void setTopic ( String topic ) {
        this.topic = topic;
    }

    public void setAuthor ( String author ) {
        this.author = author;
    }

    @Override
    public String toString ( ) {
        return "Course [ id=" + id + ", topic='" + topic + "', author='" + author + "' ]";
    }
}