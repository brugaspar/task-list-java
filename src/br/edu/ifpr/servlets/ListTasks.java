package br.edu.ifpr.servlets;

import br.edu.ifpr.entities.Task;
import br.edu.ifpr.repositories.TaskMemoryRepository;
import br.edu.ifpr.repositories.ITaskRepository;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListTasks extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  ITaskRepository repository = new TaskMemoryRepository();
   
  @Override
  public void init() throws ServletException {
    Task exampleTask = new Task();
    
    exampleTask.setTitle("Tarefa de Exemplo");
    exampleTask.setDescription("Descrição da Tarefa de Exemplo");
    
    repository.store(exampleTask);
  }
  
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("taskList", repository.findAll());
    
    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
    
    dispatcher.forward(request, response);
  }
}