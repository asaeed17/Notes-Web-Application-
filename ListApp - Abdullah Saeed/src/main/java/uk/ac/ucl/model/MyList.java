package uk.ac.ucl.model;

//each item list added by the user will be of type MyList
public class MyList
{
    private int id;
    private String name;
    private String text;
    private String url;
    private String image_url;
    private int linked_list_id;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getText() {return text;}

    public void setText(String text) {this.text = text;}

    public String getUrl() {return url;}

    public void setUrl(String url) {this.url = url;}

    public String getImage_url() {return image_url;}

    public void setImage_url(String image_url) {this.image_url = image_url;}

    public void setLinked_list_id(int linked_list_id) {this.linked_list_id = linked_list_id;}
    public int getLinked_list_id(){return linked_list_id;}
}