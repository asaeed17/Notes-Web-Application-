package uk.ac.ucl.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Json_list
{
    Model model = ModelFactory.getModel();
    //this JSON list will contain all the user's lists of type MyList
    public ArrayList<MyList> my_json_list = new ArrayList<>(model.readFile(new File("./data/lists_storage.json")));

    public Json_list() throws IOException {}
}
