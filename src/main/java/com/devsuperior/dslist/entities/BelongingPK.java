package com.devsuperior.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BelongingPK {

  @ManyToOne
  @JoinColumn(name = "game_id")
  private Game gane;

  @ManyToOne
  @JoinColumn(name = "list_id")
  private GameList list;

  public BelongingPK(Game gane, GameList list) {
    this.gane = gane;
    this.list = list;
  }

  public Game getGane() {
    return gane;
  }

  public void setGane(Game gane) {
    this.gane = gane;
  }

  public GameList getList() {
    return list;
  }

  public void setList(GameList list) {
    this.list = list;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((gane == null) ? 0 : gane.hashCode());
    result = prime * result + ((list == null) ? 0 : list.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    BelongingPK other = (BelongingPK) obj;
    if (gane == null) {
      if (other.gane != null)
        return false;
    } else if (!gane.equals(other.gane))
      return false;
    if (list == null) {
      if (other.list != null)
        return false;
    } else if (!list.equals(other.list))
      return false;
    return true;
  }
}
