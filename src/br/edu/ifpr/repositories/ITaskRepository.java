package br.edu.ifpr.repositories;

import br.edu.ifpr.entities.Task;

import java.util.List;

public interface ITaskRepository {
	public List<Task> findAll();
	
	public Task findById(String id);
	
	public Task store(Task task);
}