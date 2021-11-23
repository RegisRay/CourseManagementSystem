package courseManagementSystem;
import java.util.*;
public class courseManagement {
	Scanner scan=new Scanner(System.in);
	static courseManagement cmsObj=new courseManagement();
	static String role, name;
	ArrayList<HashMap<String, String>> course=new ArrayList<>();
	void loginScan() {
		System.out.print("Enter your name:");
		name=scan.nextLine();
		System.out.print("Enter your role:(A/S)");
		role=scan.nextLine();
	}
	void createCourse() {
		HashMap<String, String> courseDets=new HashMap<>();
		System.out.println("Creating a New Course");
		System.out.print("Enter the Course No:");
		scan.nextLine();
		String courseNo=scan.nextLine();
		courseDets.put("Course No", courseNo);
		System.out.println("Enter the Course Name:");
		String courseName=scan.nextLine();
		courseDets.put("Course Name", courseName);
		System.out.print("Enter the year:");
		String year=scan.nextLine();
		courseDets.put("Year", year);
		System.out.print("Enter the Course Description:");
		String courseDes=scan.nextLine();
		courseDets.put("Course Description", courseDes);	
		course.add(courseDets);
	}
	void updateCourse() {
		String courseNo;
		int flag=0;
		HashMap<String, String> temp=new HashMap<>();
		System.out.println("Enter the course no to be updated:");
		scan.nextLine();
		courseNo=scan.nextLine();
		for(HashMap<String, String>indiCourse:course) {
			if(indiCourse.get("Course No").equals(courseNo)) {
				temp=indiCourse;
				flag=1;
			}
		}
		if(flag==1) {
			System.out.print("Enter the Course No:");
			scan.nextLine();
			String courseno=scan.nextLine();
			HashMap<String, String> courseDets = null;
			courseDets.put("Course No", courseNo);
			System.out.println("Enter the Course Name:");
			String courseName=scan.nextLine();
			courseDets.put("Course Name", courseName);
			System.out.print("Enter the year:");
			String year=scan.nextLine();
			courseDets.put("Year", year);
			System.out.print("Enter the Course Description:");
			String courseDes=scan.nextLine();
			courseDets.put("Course Description", courseDes);	
			course.add(courseDets);
			
		}
		else {
			System.out.println("Invalid Course no");
		}
		
		
	}
	void deleteCourse() {
		System.out.println("Enter the Course No:");
		scan.nextLine();
		String courseNo=scan.nextLine();
		int i=0,flag=0;
		for(HashMap<String, String>indiCourse:course) {
			if(indiCourse.get("Course No").equals(courseNo)) {
				flag=1;
				break;
			}
			i++;
		}
		if(flag==1) {
			course.remove(i);
		}
		else {
			System.out.println("Invalid Course no");
		}
		
	}
	void displayCourse() {
		System.out.println("Displaying Courses:");
		for(HashMap<String, String> indiCourse:course) {
			System.out.println("=================================");
			System.out.println("Course Name:"+indiCourse.get("Course Name"));
			System.out.println("Course No:"+indiCourse.get("Course No"));
			System.out.println("Year:"+indiCourse.get("Year"));
			System.out.println("Course Description:"+indiCourse.get("Course Description"));
		}
		System.out.println("=================================");
	}
	void adminLogin() {
		int choice;
		do {
			System.out.print("1.Create Course 2.Update Course 3.Delete Course 4.Display Course 5.Exit");
			choice=scan.nextInt();
			switch(choice) {
				case 1:{
					cmsObj.createCourse();
					break;
				}
				case 2:
					cmsObj.updateCourse();
					break;
				case 3:
					cmsObj.deleteCourse();
					break;
				case 4:
					cmsObj.displayCourse();
					break;
				default:
					System.out.println("Exiting....");
					break;
			}
			
		}while(choice<=4);
	}
	void studentLogin() {
		
	}
	public static void main(String[] args) {
		
		cmsObj.loginScan();
		if(role.equals("A")) {
			cmsObj.adminLogin();
		}
		else if(role.equals("S")) {
			cmsObj.studentLogin();
		}
	}
}
