package br.edu.ifpr.entities;

public enum TaskStatus {
  NOT_STARTED("Não iniciado"),
  IN_PROGRESS("Em andamento"),
  COMPLETED("Completo"),
  CANCELED("Cancelado");
  
  private final String statusName;
  
  TaskStatus(String name) {
    this.statusName = name;
  }
  
  public String getStatusName() {
    return statusName;
  }
}