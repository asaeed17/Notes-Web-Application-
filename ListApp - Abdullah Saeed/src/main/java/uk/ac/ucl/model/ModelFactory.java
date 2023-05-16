package uk.ac.ucl.model;

import java.io.IOException;

public class ModelFactory
{
  private static Model model;

  public static Model getModel() throws IOException
  {
    if (model == null)
    {
      model = new Model();
    }
    return model;
  }
}
