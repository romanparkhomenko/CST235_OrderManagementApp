package view;


import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class NavigationBean implements Serializable {
  private static final long serialVersionUID = 1L;
 
  private String page="login.xhtml";
 
  public String getPage() {
    return page;
  }
 
  public void setPage(String currentPage) {
    this.page = currentPage;
  }
}