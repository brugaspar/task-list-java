package br.edu.ifpr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpr.entities.Task;
import br.edu.ifpr.repositories.TaskMemoryRepository;
import br.edu.ifpr.repositories.ITaskRepository;

@WebServlet("/tasks/new")
public class CreateTask extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  ITaskRepository repository = new TaskMemoryRepository();
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String taskTitle = request.getParameter("taskTitle");
    String taskDescription = request.getParameter("taskDescription");
    
    Task task = new Task();
    
    task.setTitle(taskTitle);
    task.setDescription(taskDescription);
    
    repository.store(task);
    
    response.sendRedirect("/app");
  }
}