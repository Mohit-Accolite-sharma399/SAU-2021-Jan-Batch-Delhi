package Question1;

import java.util.* ; 

public class Employee {
	HashSet<Project> projects ;
	HashMap<Integer , Project> project_with_year ; 
	Project projectA ; 

	public Project getProjectA() {
		return projectA;
	}

	public void setProjectA(Project projectA) {
		this.projectA = projectA;
	}

	public HashSet<Project> getProjects() {
		return projects;
	}

	public void setProjects(HashSet<Project> projects) {
		this.projects = projects;
	}
	
	public void printProjects(){
		for(Project proj: projects){
			System.out.println("Project ID: " + proj.getId() + " Project Name: " + proj.getName()) ; 
		}
	}
	
	public void printProject_with_year(){
		for(int year : project_with_year.keySet()){
			System.out.println("Project Year : " + year + " Project ID: " + project_with_year.get(year).getId() + " Project Name: " + project_with_year.get(year).getName()) ; 
		}
	}
	
	public void showProjectA(){
		System.out.println("This is projectA : " + projectA.id + " " + projectA.name) ; 
	}

	public HashMap<Integer, Project> getProject_with_year() {
		return project_with_year;
	}

	public void setProject_with_year(HashMap<Integer, Project> project_with_year) {
		this.project_with_year = project_with_year;
	}
	
}
