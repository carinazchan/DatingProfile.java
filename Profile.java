/*
Carina Zelda Chan
2367721
carchan@chapman.edu
CPSC-231-04
Mastery Project 1: Recursion and Intro to Classes - Profile
*/

/*
OVERVIEW:
Profile.java creates dating profiles and keeps a list of people that a user
likes. It also matches people if they like eachother.
*/

//NOTES
/*
D+I = Declare+Initialize
*/

//Profile class START
public class Profile {


  //PRIVATE MEMBER VARIABLES//--------------------------------------------------
  /*
  name private variable

  description - type:
  private variable that holds the Profile's name - String
  */
  private String name;

  /*
  age private variable

  description:
  private variable that holds the Profile's age - int
  */
  private int age;

  /*
  likesArr private variable

  description - type:
  private variable that holds an array of people that they like - array
  */
    //Number of elements is 11 - an error message will be able to be printed
  private Profile[] likesArr = new Profile[11];

  /*
  matchesArr private variable

  description - type:
  private variable that holds an array of people that they match with - array
  */
    //Number of elements is 11 - an error message will be able to be printed
  private Profile[] matchesArr = new Profile[11];

  /*
  likesIndex private variable

  description - type:
  private variable that holds the index number for likesArr - array
  */
  private int likesIndex = 0;

  /*
  matchesIndex private variable

  description - type:
  private variable that holds the index number for matchesArr - array
  */
  private int matchesIndex = 0;

  //PROFILE CONSTRUCTORS--------------------------------------------------------
  /*
  Profile method

  description - type:
  default profile given no parameters - Profile
  */
  public Profile() {
    name = "Unknown";
    age = 0;
  }


  /*
  Profile method

  parameter, description - type:
  n, given name - String

  parameter, description - type:
  a, given age - int
  */
  Profile(String n, int a) {
    this.name = n;
    this.age = a;
  }

  //MUTATORS + ACCESSORS--------------------------------------------------------
  /*
  getName method

  return, description - type:
  name, accesses name from private variable - String
  */
  public String getName() {
    return name;
  }

  /*
  setName method

  description:
  overloading the name with String n
  */
  public void setName(String n) {
    name = n;
  }

  /*
  getAge method

  return, description - type:
  age, accesses age from private variable - int
  */
  public int getAge() {
    return age;
  }

  /*
  setAge method

  description:
  overloading the age with int a
  */
  public void setAge(int a) {
    age = a;
  }

  //METHODS---------------------------------------------------------------------
  /*
  toString method

  return, description - type:
  completeProfile, nicely formatted profile of use - String
  */
  public String toString() {
    String completeProfile = ""; //String that is to be returned

    completeProfile += "Name: " + name + "\n";
    completeProfile += "Age: " + age + "\n";

    //Iterate through and print profile's likesArr
    completeProfile += "Likes: ";
    int h;
    for (h=0; h<this.likesIndex; h++){
      if (this.likesArr[h] == null) { //If the profile got removed, add empty string
        completeProfile += "";
      }
      else {
        completeProfile += this.likesArr[h].getName() + " ";
      }
    }
    completeProfile += "\n";

    //Iterate through and print profile's matchesArr
    completeProfile += "Matches: ";
    int f;
    for (f=0; f<this.matchesIndex; f++){
      completeProfile += this.matchesArr[f].getName() + " ";
    }
    completeProfile += "\n";

    return completeProfile;
  }


  /*
  equals method

  return, description - type:
  answer, evaluates if two profiles are the same - boolean

  parameter, description - type:
  p1, profile that is being compared - Profile
  */
  public boolean equals(Profile p1) {
    boolean answer = true; //D+I answer as true

    //If both profiles' names are not the same --> answer = false
    if (!(p1.getName() == this.getName())) {
      answer = false;
    }

    return answer;
  }


  /*
  swipeRight method

  return, description:
  void, adds a profile to another's likesArr and evaluates if both profiles
  are in eachothers' likesArr (yes --> add eachother to their matchesArr,
  no --> nothing)

  parameter, description - type:
  p1, profile that is recieving a profile into their likesArr - Profile
  */
  public void swipeRight(Profile p1) {

    //If spot in likesArr is empty and index number is less than 10
    if ((p1.likesArr[p1.likesIndex] == null) && (p1.likesIndex < 10)) {
      //Put current profile into p1's likesArr
      p1.likesArr[p1.likesIndex] = this;

      //Increment p1's likesIndex number to move to next open spot in likesArr
      p1.likesIndex++;

      //Evaluate if profiles are a match
      int b;
      for(b=0;b<this.likesIndex;b++) {
       if(this.likesArr[b] == p1) {
         //Put eachother's profiles into eachother's matchesArr
         p1.matchesArr[p1.matchesIndex] = this;
         this.matchesArr[this.matchesIndex] = p1;

         //Increment p1 and this's matchesIndex number to move to next open spot in matchesArr
         p1.matchesIndex++;
         this.matchesIndex++;
       }
     }
   }

    //If profile's likesArr is full
    else {
      System.out.println("This user has a maximum of 10 people they like: " + p1.likesIndex);
    }
  }


  /*
  swipeLeft method

  return, description:
  void, removes a profile from another's likesArr

  parameter, description - type:
  p, profile that is being removed - Profile
  */
  public void swipeLeft(Profile p) {

    int c;
    for(c=0; c<this.likesArr.length; c++){

      //Replaces the profile with null
      if (this.likesArr[c] == p) {
        this.likesArr[c] = null;
      }
    }
  }



/*-------------------------------MAIN-----------------------------------------*/


  public static void main (String[] args) {

    //Create user profiles
    Profile uProfile1 = new Profile("Carina", 20);
    Profile uProfile2 = new Profile("Natalie", 26);
    Profile uProfile3 = new Profile("Flavia", 19);
    Profile uProfile4 = new Profile("Ms. Julie", 30);


/*
Assignment: Takes in an instance of another Profile and adds the current Profile
to the other Profile’s like array.
*/
    //Instantiate swipeRight
      //uProfile1 in uProfile2 likesArr
    uProfile1.swipeRight(uProfile2);
      //uProfile1 in uProfile3 likesArr
    uProfile1.swipeRight(uProfile3);
      //uProfile3 in uProfile1 likesArr
    uProfile3.swipeRight(uProfile1);
      //uProfile4 in uProfile1 likesArr
    uProfile4.swipeRight(uProfile1);
      //uProfile4 in uProfile2 likesArr
    uProfile4.swipeRight(uProfile2);


/*
Assignment: Takes in an instance of another dating profile and deletes that profile
from the current Profile’s like array. (It does nothing with the matched array)
*/
    //Instantiate swipeLeft
      //remove uProfile4 from uProfile1
    uProfile1.swipeLeft(uProfile4);


    //Instantiate toString - printing all profiles
    System.out.print(uProfile1.toString() + "\n");
    System.out.print(uProfile2.toString() + "\n");
    System.out.print(uProfile3.toString() + "\n");
    System.out.print(uProfile4.toString() + "\n");
  }
}
