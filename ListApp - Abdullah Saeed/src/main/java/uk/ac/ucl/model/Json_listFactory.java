package uk.ac.ucl.model;

import java.io.File;
import java.io.IOException;

public class Json_listFactory
{
    private static Json_list json_list;

    public static Json_list getJson_list() throws IOException {
        if (json_list == null)
        {
            json_list = new Json_list();
        }
        return json_list;   //json_list is a singleton class
    }
}
