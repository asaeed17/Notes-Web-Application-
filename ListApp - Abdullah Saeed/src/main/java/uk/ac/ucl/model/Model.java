package uk.ac.ucl.model;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Model
{
  public static Type type = new TypeToken<ArrayList<MyList>>(){}.getType(); //generic type, allows reading of JSON file
  public static ArrayList<MyList> readList;

  //Read the JSON file
  public ArrayList<MyList> readFile(File file) throws FileNotFoundException {
    Gson gson = new Gson();

    try (Reader reader = new FileReader(file))
    {
      readList = gson.fromJson(reader, type);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return readList;
  }

  //Write to the JSON file
  public void write_to_json() throws IOException {
    Gson gson = new Gson();
    Json_list jsonList = Json_listFactory.getJson_list();
    try(FileWriter writer = new FileWriter("data/lists_storage.json"))
    {
      writer.write(gson.toJson(jsonList.my_json_list)); //add json string to json file
    }
    catch (IOException err)
    {
      err.printStackTrace();
    }
  }

  //get all the list names present in the JSON file
  public List<String> getListNames() throws IOException {
    List<String> names_list = new ArrayList<>();
    Json_list jsonList = Json_listFactory.getJson_list();

    for (int i = 0; i < jsonList.my_json_list.size(); i++)
    {
      String list_name = jsonList.my_json_list.get(i).getName();  //get list name
      names_list.add(list_name);
    }

    return names_list;
  }

  //get all the list IDs present in the JSON file
  public List<Integer> getListIds() throws IOException {
    List<Integer> id_list = new ArrayList<>();
    Json_list jsonList = Json_listFactory.getJson_list();

    for (int i = 0; i < jsonList.my_json_list.size(); i++)
    {
      int list_id = jsonList.my_json_list.get(i).getId();  //get list name
      id_list.add(list_id);
    }

    return id_list;
  }

  //get a list from the JSON file through its ID
  public MyList get_list_by_id(int id) throws IOException {
    Json_list jsonList = Json_listFactory.getJson_list();
    MyList myList = new MyList();
    for (int i = 0; i < jsonList.my_json_list.size(); i++)
    {
      if (jsonList.my_json_list.get(i).getId() == id)
      {
        return jsonList.my_json_list.get(i);  //return MyList with the given id
      }
    }
    return myList;
  }

 //Search for a list name using a given keyword
  public List<String> searchForName(String keyword) throws IOException {
    List<String> names_found = new ArrayList<>();
    Json_list jsonList = Json_listFactory.getJson_list();

    for (int i = 0; i < jsonList.my_json_list.size(); i++)
    {
      String list_name = jsonList.my_json_list.get(i).getName();  //get list name
      if ((list_name).equalsIgnoreCase(keyword))
      {
        names_found.add(list_name);
      }
    }

    return names_found;
  }

  //Search for a list's ID by searching for the list name
  public List<Integer> searchForId(String keyword) throws IOException {
    List<Integer> ids_found = new ArrayList<>();
    Json_list jsonList = Json_listFactory.getJson_list();

    for (int i = 0; i < jsonList.my_json_list.size(); i++)
    {
      String list_name = jsonList.my_json_list.get(i).getName();  //get list name
      if (list_name.equalsIgnoreCase(keyword))
      {
        ids_found.add(jsonList.my_json_list.get(i).getId());
      }
    }

    return ids_found;
  }

// add user's new list to json file
  public void add_list(String list_name, String text, String url, String image_url, int linked_list_id) throws IOException {
    Gson gson = new Gson();
    Json_list jsonList = Json_listFactory.getJson_list();

    int list_id = jsonList.my_json_list.size() + 1;
    MyList my_list = new MyList();

    my_list.setId(list_id);
    my_list.setName(list_name);
    my_list.setText(text);
    my_list.setUrl(url);
    my_list.setImage_url(image_url);
    my_list.setLinked_list_id(linked_list_id);

    jsonList.my_json_list.add(my_list); //add user's new list to big json list
    write_to_json();
  }

  //Delete any desired list
  public void delete_list(int id) throws IOException {
    Json_list jsonList = Json_listFactory.getJson_list();

      for (int i = 0; i < jsonList.my_json_list.size(); i++)
      {
        if (jsonList.my_json_list.get(i).getId() == id)
        {
          jsonList.my_json_list.remove(i);
          break;
        }
      }
    write_to_json();
  }

  //Edit any desired list
  public void edit_list(int id, String list_name, String text, String url, String image_url, int linked_list_id) throws IOException {
    Json_list jsonList = Json_listFactory.getJson_list();

    for (int i = 0; i < jsonList.my_json_list.size(); i++)
    {
      if (jsonList.my_json_list.get(i).getId() == id)
      {
        if (!list_name.isEmpty()){jsonList.my_json_list.get(i).setName(list_name);}
        if (!text.isEmpty()){jsonList.my_json_list.get(i).setText(text);}
        if (!url.isEmpty()){jsonList.my_json_list.get(i).setUrl(url);}
        if (!image_url.isEmpty()){jsonList.my_json_list.get(i).setImage_url(image_url);}
        jsonList.my_json_list.get(i).setLinked_list_id(linked_list_id);   //linked_list_id will either be None or something else
        break;
      }
    }
    write_to_json();
  }
}