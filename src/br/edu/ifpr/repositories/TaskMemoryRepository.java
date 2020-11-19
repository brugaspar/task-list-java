package br.edu.ifpr.repositories;

import br.edu.ifpr.entities.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskMemoryRepository implements ITaskRepository {
  private static List<Task> tasks = new ArrayList<Task>();
  
  @Override
  public List<Task> findAll() {
    return tasks;
  }

  @Override
  public Task findById(String id) {
    for(Task task : tasks) {
      if(id == task.getId()) {
        return task;
      }
    }
    
    throw new IllegalArgumentException("Ops! ID não encontrado");
  }

  @Override
  public Task store(Task task) {
    tasks.add(task);
    
    return task;
  } 
}