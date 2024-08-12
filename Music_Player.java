/* Title: Music Player using Doubly Linked List
 * Enrollment number: 22002171310158
 * Date: 30/09/23
 * Subject: Data Structure using Java */

// Importing necessary Java packages
import java.util.*;

// Definition of the MusicPlayer class
class MusicPlayer {
    // Definition of the inner MusicNode class
    class MusicNode {
        String song;
        MusicNode next;
        MusicNode prev;
        
        // Constructor for MusicNode
        MusicNode(String song) {
            this.song = song;
            next = null;
            prev = null;
        }
    }

    // Initialize the first song node to null
    MusicNode firstSong = null;

    // Method to add a song at the top of the playlist
    void AddSongAtTop(String song) {
        MusicNode current=new MusicNode(song);
        if(firstSong==null){
            firstSong=current;
        }
        else{
            current.next=firstSong;
            firstSong.prev=current;
            firstSong=current;
        }
    }

    // Method to add a song at the end of the playlist
    void AddSongAtEnd(String song) {
        MusicNode current=new MusicNode(song);
        if(firstSong==null){
            firstSong=current;
        }
        else{
            MusicNode temp=firstSong;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=current;
            current.prev=temp;
        }
    }

    // Method to insert a new song before a particular song in the playlist
    void InsertBeforeSong(String newSong, String song) {
        if (firstSong == null) {
            System.out.println("Music queue is empty");
            return;
        }
    
        if (firstSong.song.equals(newSong)) {
            MusicNode current = new MusicNode(song);
            current.next = firstSong;
            firstSong.prev = current;
            firstSong = current;
            return;
        }
    
        MusicNode temp = firstSong;
        while (temp != null) {
            if (temp.song.equals(newSong)) {
                MusicNode current = new MusicNode(song);
                current.prev = temp.prev;
                current.next = temp;
                temp.prev.next = current;
                temp.prev = current;
                return;
            }
            temp = temp.next;
        }
    
        System.out.println("Song '" + newSong + "' not found in the playlist.");
    }

    // Method to insert a new song after a particular song in the playlist
    void InsertAfterSong(String newSong, String song) {
        if (firstSong == null) {
            System.out.println("Music queue is empty");
            return;
        }
    
        MusicNode temp = firstSong;
        while (temp != null) {
            if (temp.song.equals(newSong)) {
                MusicNode current = new MusicNode(song);
                current.next = temp.next;
                current.prev = temp;
                if (temp.next != null) {
                    temp.next.prev = current;
                }
                temp.next = current;
                return;
            }
            temp = temp.next;
        }
    
        System.out.println("Song '" + newSong + "' not found in the playlist.");
    }

    // Method to delete the first song from the playlist
    void DeleteFirstSong() {
        if(firstSong==null){
            System.out.println("Music queue is empty");
        }
        else if(firstSong.next==null&&firstSong.prev==null){
            firstSong=null;
        }
        else{
            MusicNode temp=firstSong;
            firstSong=firstSong.next;
            firstSong.prev=null;
            temp=null;
        }
    }

    // Method to delete the last song from the playlist
    void DeleteLastSong() {
        if(firstSong==null){
           System.out.println("Music queue is empty");
        }
        else if(firstSong.next==null&&firstSong.prev==null){
           firstSong=null;
        }
        else{
           MusicNode temp=firstSong;
           while(temp.next!=null){
               temp=temp.next;
           }
           temp.prev.next=null;
           temp.prev=null;
        }
    }

    // Method to delete a particular song from the playlist
    void DeleteparticularSong(String delSong) {
        if (firstSong == null) {
            System.out.println("Music queue is empty");
            return;
        }
    
        if (firstSong.song.equals(delSong)) {
            firstSong = firstSong.next;
            if (firstSong != null) {
                firstSong.prev = null;
            }
            return;
        }

        MusicNode temp = firstSong;
        while (temp != null) {
            if (temp.song.equals(delSong)) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                }
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
        System.out.println("Song '" + delSong + "' not found in the playlist.");
    }
    // Defining temp variable with MusicNode as its type
    MusicNode temp;

    // Method to play the next song in the playlist
    void playNextSong() {
        if (temp == null) {
            temp = firstSong;
            if (temp == null) {
                System.out.println("No songs in the playlist.");
            } else {
                System.out.println("Playing first song: " + temp.next.song);
            }
        } else if (temp.next.next == null) {
            System.out.println("End of playlist. No next song to play.");
        } else {
            temp = temp.next;
            System.out.println("Playing next song: " + temp.next.song);
        }
    }

    // Method to play the previous song in the playlist
    void playPreviousSong() {
        if (temp == null) {
            temp = firstSong;
            if (temp == null) {
                System.out.println("No songs in the playlist.");
            } else {
                System.out.println("End of playlist. No previous song to play.");
            }
        } else if (temp.prev == null) {            
            System.out.println("Start of playlist. Playing first song: " + temp.song);
            temp = temp.prev;
        } else {
            temp = temp.prev;
            System.out.println("check1");
            System.out.println("Playing previous song: " + temp.next.song);
        }
    }

    // Method to display the songs in the playlist
    void displaySongs() {
        if(firstSong==(null)){
            System.out.println("Music queue is empty");
        }else{
            MusicNode temp=firstSong;
            while(temp!=null){
                System.out.print(temp.song+"-->");
                temp=temp.next;
            }
            System.out.println("NULL");
        
        }
    }

    // Method to reverse and display the songs in the playlist
    void reverseDisplaySongs() {
        if(firstSong==null){
            System.out.println("Music queue is empty");
        }
        else{
            MusicNode temp = firstSong;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            while(temp!=null)
            {
                System.out.print(temp.song+"-->");
                temp=temp.prev;
            }
            System.out.println("NULL");
        }
    }

    // Method to search for a song in the playlist
    MusicNode searchSong(String songName) {
        MusicNode temp = firstSong;
        while (temp != null) {
            if (temp.song.equals(songName)) {
                return temp; 
            }
            temp = temp.next;
        }
        return null; 
    }

    // Add a new node to the end of the doubly linked list
    public void add(String song) {
        MusicNode newNode = new MusicNode(song);
        if (firstSong == null) {
            firstSong = newNode;
            temp = newNode;
        } else {
            temp.next = newNode;
            newNode.prev = temp;
            temp = newNode;
        }
    }

    // Get the size of the doubly linked list
    public int size() {
        int size = 0;
        MusicNode current = firstSong;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    // Retrieve a song at a given index
    public String get(int index) {
        int counter = 0;
        MusicNode current = firstSong;
        while (current != null) {
            if (counter == index) {
                System.out.println("Track name:"+current.song+"");
                return current.song;
            }
            counter++;
            current = current.next;
        }
        return null; // index out of bounds
    }

    // Check if the doubly linked list contains a given song
    public boolean contains(String song) {
        MusicNode current = firstSong;
        while (current != null) {
            if (current.song.equals(song)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Random number generator for shuffling
    private long seed;
    private static final long a = 1664525;
    private static final long c = 1013904223;
    private static final long m = (long) Math.pow(2, 32);

    // Parametrized constructor
    public MusicPlayer(long seed) {
        this.seed = seed;
    }
    // Empty Constructor
    MusicPlayer(){

    }
    // Method nextInt having bound as parameter and return type long
    public long nextInt(int bound) {
        seed = (a * seed + c) % m;
        return (seed % bound);
    }
}

// Main class for running the music player
class RunMusicPlayer {
    public static void main(String args[]) {
        // Initialize a scanner for user input
        Scanner sc = new Scanner(System.in);
        
        // Create a MusicPlayer instance
        MusicPlayer playSong = new MusicPlayer();
        MusicPlayer tracks = new MusicPlayer();

        // Main menu and user interaction
        int ch;
        System.out.println("-----------------------MUSIC PLAYER----------------------");
        String newSong;
        String curSong;
        do {
            // Display the menu
            System.out.println();
            System.out.println("""
                                MENU
                    1. Add song to my Playlist
                    2. Delete song from my Playlist
                    3. Play next song
                    4. Play previous song
                    5. Shuffle my Playlist
                    6. Search particular song from my Playlist
                    7. Show my Playlist
                    8. Reverse my Playlist
                    9. Exit
                    
                    "Enter your choice
                    """);
            ch=sc.nextInt();

            // Handle user choices
            switch (ch) {
                case 1:
                    // Add song to the playlist
                    int a;
                    do {
                        System.out.println("1. Add song at the top of my Playlist");
                        System.out.println("2. Add song at the end of my Playlist");
                        System.out.println("3. Add song before a particular song in my Playlist");
                        System.out.println("4. Add song after a particular song in my Playlist");
                        System.out.println("5. Exit");
                        a=sc.nextInt();
                        switch(a)
                        {
                            case 1: 
                            // Add song at the top of playlist
                            System.out.println("Enter Song: ");
                            newSong=sc.next();
                            playSong.AddSongAtTop(newSong);
                            tracks.add(newSong);
                            break;

                            case 2:
                            // Add song at the end of playlist
                            System.out.println("Enter Song: ");
                            newSong=sc.next();
                            playSong.AddSongAtEnd(newSong);
                            tracks.add(newSong);
                            break;

                            case 3:
                            // Add song before a particular song in the playlist
                            System.out.println("Enter Song: ");
                            newSong=sc.next();
                            System.out.println("Enter Song before which you want to add: ");
                            curSong=sc.next();
                            playSong.InsertBeforeSong(curSong,newSong);
                            tracks.add(newSong);
                            break;

                            case 4:
                            // Add song after a particular song in the playlist
                            System.out.println("Enter Song: ");
                            newSong=sc.next();
                            System.out.println("Enter Song after which you want to add: ");
                            curSong=sc.next();
                            playSong.InsertAfterSong(curSong,newSong);
                            tracks.add(newSong);
                            break;

                            case 5:
                            // Exiting the add to playlist case
                            break;

                            default:
                            // Default case 
                            System.out.println("Invalid Choice");
                        }
                    }while(a!=5);
                    break;

                case 2:
                    // Delete song from the playlist
                    int b;
                    do {
                        System.out.println("1. Delete first song of my Playlist");
                        System.out.println("2. Delete last song of my Playlist");
                        System.out.println("3. Delete particular song of my Playlist");
                        System.out.println("4. Exit");
                        b=sc.nextInt();
                        switch(b)
                        {
                            case 1:
                            // Delete first song from the playlist
                            playSong.DeleteFirstSong();
                            break;

                            case 2:
                            // Delete last song from the playlist
                            playSong.DeleteLastSong();
                            break;

                            case 3:
                            // Delete a particular song from the playlist
                            System.out.println("Enter song to be deleted: ");
                            String delSong=sc.next();
                            playSong.DeleteparticularSong(delSong);
                            break;

                            case 4:
                            // Exiting the delete from playlist case
                            break;

                            default:
                            // Default case
                            System.out.println("Invalid Choice");
                        }
                        
                    }while(b!=4);
                    break;
                    
                case 3:
                    // Play next song
                    playSong.playNextSong();
                    break;

                case 4:
                    // Play previous song
                    playSong.playPreviousSong();
                    break;

                case 5:
                    // Shuffle the playlist
                    int playedCount = 0;
                    MusicPlayer rand = new MusicPlayer(System.currentTimeMillis());
                    boolean[] played = new boolean[tracks.size()];

                    while (playedCount < tracks.size()) {
                    int randomIndex = (int) rand.nextInt(tracks.size());

                        if (!played[randomIndex]) {
                            tracks.get(randomIndex);
                            played[randomIndex] = true;
                            playedCount++;
                        }
                    }
                    break;

                case 6:
                    // Search for a song in the playlist
                    System.out.println("Enter song to search: ");
                    String searchSong = sc.next();
                    MusicPlayer.MusicNode foundNode = playSong.searchSong(searchSong);
                    if (foundNode != null) {
                        System.out.println("Song '" + searchSong + "' found in the playlist.");
                    } else {
                        System.out.println("Song '" + searchSong + "' not found in the playlist.");
                        System.out.println("Do you want to add it to the playlist? (yes/no)");
                        String addToPlaylist = sc.next();
                        if (addToPlaylist.equalsIgnoreCase("yes")) {
                            playSong.AddSongAtEnd(searchSong);
                            System.out.println("Song '" + searchSong + "' added to the playlist.");
                        }
                    }
                    break;

                case 7:
                    // Show the playlist
                    playSong.displaySongs();
                    break;

                case 8:
                    // Reverse the playlist and show
                    playSong.reverseDisplaySongs();
                    break;

                case 9:
                    // Exit the program
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        } while (ch != 9);
    }
}

//------------- OUTPUT TEST CASES -------------

/*-----------------------MUSIC PLAYER----------------------

MENU
1. Add song to my Playlist
2. Delete song from my Playlist
3. Play next song
4. Play previous song
5. Shuffle my Playlist
6. Search particular song from my Playlist
7. Show my Playlist
8. Reverse my Playlist
9. Exit
Enter your choice
1
1. Add song at the top of my Playlist
2. Add song at the end of my Playlist
3. Add song before a particular song in my Playlist
4. Add song after a particular song in my Playlist
5. Exit
1
Enter Song: 
song1
1. Add song at the top of my Playlist
2. Add song at the end of my Playlist
3. Add song before a particular song in my Playlist
4. Add song after a particular song in my Playlist
5. Exit
1
Enter Song:
song2
1. Add song at the top of my Playlist
2. Add song at the end of my Playlist
3. Add song before a particular song in my Playlist
4. Add song after a particular song in my Playlist
5. Exit
2
Enter Song:
song3
1. Add song at the top of my Playlist
2. Add song at the end of my Playlist
3. Add song before a particular song in my Playlist
4. Add song after a particular song in my Playlist
5. Exit
3
Enter Song:
song4
Enter Song before which you want to add:
song1
1. Add song at the top of my Playlist
2. Add song at the end of my Playlist
3. Add song before a particular song in my Playlist
4. Add song after a particular song in my Playlist
5. Exit
4
Enter Song:
song5
Enter Song after which you want to add:
song3
1. Add song at the top of my Playlist
2. Add song at the end of my Playlist
3. Add song before a particular song in my Playlist
4. Add song after a particular song in my Playlist
5. Exit
5

MENU
1. Add song to my Playlist
2. Delete song from my Playlist
3. Play next song
4. Play previous song
5. Shuffle my Playlist
6. Search particular song from my Playlist
7. Show my Playlist
8. Reverse my Playlist
9. Exit
Enter your choice
7
song2-->song4-->song1-->song3-->song5-->NULL

MENU
1. Add song to my Playlist
2. Delete song from my Playlist
3. Play next song
4. Play previous song
5. Shuffle my Playlist
6. Search particular song from my Playlist
7. Show my Playlist
8. Reverse my Playlist
9. Exit
Enter your choice
2
1. Delete first song of my Playlist
2. Delete last song of my Playlist
3. Delete particular song of my Playlist
4. Exit
1
1. Delete first song of my Playlist
2. Delete last song of my Playlist
3. Delete particular song of my Playlist
4. Exit
2
1. Delete first song of my Playlist
2. Delete last song of my Playlist
3. Delete particular song of my Playlist
4. Exit
4

MENU
1. Add song to my Playlist
2. Delete song from my Playlist
3. Play next song
4. Play previous song
5. Shuffle my Playlist
6. Search particular song from my Playlist
7. Show my Playlist
8. Reverse my Playlist
9. Exit
Enter your choice
7
song4-->song1-->song3-->NULL

MENU
1. Add song to my Playlist
2. Delete song from my Playlist
3. Play next song
4. Play previous song
5. Shuffle my Playlist
6. Search particular song from my Playlist
7. Show my Playlist
8. Reverse my Playlist
9. Exit
Enter your choice
2
1. Delete first song of my Playlist
2. Delete last song of my Playlist
3. Delete particular song of my Playlist
4. Exit
3
Enter song to be deleted:
song1
1. Delete first song of my Playlist
2. Delete last song of my Playlist
3. Delete particular song of my Playlist
4. Exit
4

MENU
1. Add song to my Playlist
2. Delete song from my Playlist
3. Play next song
4. Play previous song
5. Shuffle my Playlist
6. Search particular song from my Playlist
7. Show my Playlist
8. Reverse my Playlist
9. Exit
Enter your choice
7
song4-->song3-->NULL

MENU
1. Add song to my Playlist
2. Delete song from my Playlist
3. Play next song
4. Play previous song
5. Shuffle my Playlist
6. Search particular song from my Playlist
7. Show my Playlist
8. Reverse my Playlist
9. Exit
Enter your choice
1
1. Add song at the top of my Playlist
2. Add song at the end of my Playlist
3. Add song before a particular song in my Playlist
4. Add song after a particular song in my Playlist
5. Exit
1
Enter Song:
song6
1. Add song at the top of my Playlist
2. Add song at the end of my Playlist
3. Add song before a particular song in my Playlist
4. Add song after a particular song in my Playlist
5. Exit
2
Enter Song:
song7
1. Add song at the top of my Playlist
2. Add song at the end of my Playlist
3. Add song before a particular song in my Playlist
4. Add song after a particular song in my Playlist
5. Exit
2
Enter Song:
song8
1. Add song at the top of my Playlist
2. Add song at the end of my Playlist
3. Add song before a particular song in my Playlist
4. Add song after a particular song in my Playlist
5. Exit
5

MENU
1. Add song to my Playlist
2. Delete song from my Playlist
3. Play next song
4. Play previous song
5. Shuffle my Playlist
6. Search particular song from my Playlist
7. Show my Playlist
8. Reverse my Playlist
9. Exit
Enter your choice
7
song6-->song4-->song3-->song7-->song8-->NULL

MENU
1. Add song to my Playlist
2. Delete song from my Playlist
3. Play next song
4. Play previous song
5. Shuffle my Playlist
6. Search particular song from my Playlist
7. Show my Playlist
8. Reverse my Playlist
9. Exit
Enter your choice
3
Playing next song: song4

MENU
1. Add song to my Playlist
2. Delete song from my Playlist
3. Play next song
4. Play previous song
5. Shuffle my Playlist
6. Search particular song from my Playlist
7. Show my Playlist
8. Reverse my Playlist
9. Exit
Enter your choice
4
Start of playlist. No previous song to play.

MENU
1. Add song to my Playlist
2. Delete song from my Playlist
3. Play next song
4. Play previous song
5. Shuffle my Playlist
6. Search particular song from my Playlist
7. Show my Playlist
8. Reverse my Playlist
9. Exit
Enter your choice
5
Track name:song1
Track name:song8
Track name:song3
Track name:song2
Track name:song5
Track name:song4
Track name:song7
Track name:song6

MENU
1. Add song to my Playlist
2. Delete song from my Playlist
3. Play next song
4. Play previous song
5. Shuffle my Playlist
6. Search particular song from my Playlist
7. Show my Playlist
8. Reverse my Playlist
9. Exit
Enter your choice
6
Enter song to search:
song7
Song 'song7' found in the playlist.

MENU
1. Add song to my Playlist
2. Delete song from my Playlist
3. Play next song
4. Play previous song
5. Shuffle my Playlist
6. Search particular song from my Playlist
7. Show my Playlist
8. Reverse my Playlist
9. Exit
Enter your choice
6
Enter song to search:
song10
Song 'song10' not found in the playlist.
Do you want to add it to the playlist? (yes/no)
yes
Song 'song10' added to the playlist.

MENU
1. Add song to my Playlist
2. Delete song from my Playlist
3. Play next song
4. Play previous song
5. Shuffle my Playlist
6. Search particular song from my Playlist
7. Show my Playlist
8. Reverse my Playlist
9. Exit
Enter your choice
7
song6-->song4-->song3-->song7-->song8-->song10-->NULL

MENU
1. Add song to my Playlist
2. Delete song from my Playlist
3. Play next song
4. Play previous song
5. Shuffle my Playlist
6. Search particular song from my Playlist
7. Show my Playlist
8. Reverse my Playlist
9. Exit
Enter your choice
8
song10-->song8-->song7-->song3-->song4-->song6-->NULL

MENU
1. Add song to my Playlist
2. Delete song from my Playlist
3. Play next song
4. Play previous song
5. Shuffle my Playlist
6. Search particular song from my Playlist
7. Show my Playlist
8. Reverse my Playlist
9. Exit
Enter your choice
9 */