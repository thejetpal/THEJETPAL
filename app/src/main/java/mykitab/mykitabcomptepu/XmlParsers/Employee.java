package mykitab.mykitabcomptepu.XmlParsers;

/**
 * Created by Admin on 07/07/2016.
 */
public class Employee {
    private String name;
    private String link;
    private String about;
    // private String imgUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    /*  public String getImgUrl() {
          return imgUrl;
      }

      public void setImgUrl(String imgUrl) {
          this.imgUrl = imgUrl;
      }
  */
    @Override
    public String toString() {
        return "Employee [name=" + name + ", link=" + link + ", about="
                + about + "]";
    }
}

