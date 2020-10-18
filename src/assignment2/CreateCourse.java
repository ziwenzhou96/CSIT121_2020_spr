package assignment2;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateCourse {
    public static void main(String[] args) {
        Subject CSIT111 = new Subject("CSIT111", "Programming Fundamentals", 6);
        Subject CSIT113 = new Subject("CSIT113", "Problem Solving", 6);
        Subject CSIT114 = new Subject("CSIT114", "System Analysis", 6);
        Subject CSIT115 = new Subject("CSIT115", "Data Management and Security", 6);
        Subject CSIT121 = new Subject("CSIT121", "Object Oriented Design and Programming", 6);
        Subject CSIT127 = new Subject("CSIT127", "Networks and Communications", 6);
        Subject CSIT128 = new Subject("CSIT128", "Introduction to Web Technology", 6);
        Subject CSCI235 = new Subject("CSCI235", "Database Systems", 6);
        Subject CSCI251 = new Subject("CSCI251", "Advanced Programming", 6);
        Subject CSIT214 = new Subject("CSIT214", "IT Project Management", 6);
        Subject MATH221 = new Subject("MATH221", "Mathematics for Computer Science", 6);
        Subject CSCI203 = new Subject("CSCI203", "Algorithms and Data Structures", 6);
        Subject CSIT226 = new Subject("CSIT226", "Human Computer Interaction", 6);
        Subject CSIT314 = new Subject("CSIT314", "Software Development Methodologies", 6);
        Subject CSIT321 = new Subject("CSIT321", "Project", 12);
        Subject CSCI317 = new Subject("CSCI317", "Database Performance Tuning", 6);
        Subject INFO411 = new Subject("INFO411", "Data Mining and Knowledge Discovery", 6);
        Subject CSCI316 = new Subject("CSCI316", "Big Data Mining Techniques and Implementation", 6);
        Subject ISIT312 = new Subject("ISIT312", "Big Data Management", 6);
        Subject CSCI301 = new Subject("CSCI301", "Contemporary Topics in Security", 6);
        Subject CSCI262 = new Subject("CSCI262", "System Security", 6);
        Subject CSCI369 = new Subject("CSCI369", "Ethical Hacking", 6);
        Subject CSIT302 = new Subject("CSIT302", "Cybersecurity", 6);
        Subject CSCI361 = new Subject("CSCI361", "Cryptography and Secure Applications", 6);
        Subject CSCI368 = new Subject("CSCI368", "Network Security", 6);
        Subject CSCI376 = new Subject("CSCI376", "Multicore and GPU Programming", 6);
        Subject CSCI236 = new Subject("CSCI236", "3D Modelling and Animation", 6);
        Subject CSCI336 = new Subject("CSCI336", "Interactive Computer Graphics", 6);
        Subject CSCI366 = new Subject("CSCI366", "Mobile Multimedia", 6);
        Subject CSCI356 = new Subject("CSCI356", "Game Engine Essentials", 6);
        Subject CSCI334 = new Subject("CSCI334", "Software Design", 6);
        Subject ISIT219 = new Subject("ISIT219", "Knowledge and Information Engineering", 6);
        Subject CSCI318 = new Subject("CSCI318", "Software Engineering Practices & Principles", 6);
        Subject ISIT315 = new Subject("ISIT315", "Semantic Web", 6);

        Major bigData = new Major("Big Data");
        Subject[] bDataCores={CSCI317, INFO411, CSCI316, ISIT312};
        bigData.addMCores(bDataCores);

        Major cyberSec = new Major("Cyber Security");
        Subject[] cyberSecCores={CSCI301, CSCI262, CSCI369, CSIT302};
        cyberSec.addMCores(cyberSecCores);

        Major digitalSysSec = new Major("Digital System Security");
        Subject[] digitalSysSecCores={CSCI361, CSCI262, CSCI368, CSCI376};
        digitalSysSec.addMCores(digitalSysSecCores);

        Major gameMobDev = new Major("Game and Mobile Development");
        Subject[] gameMobDevCores={CSCI236, CSCI336, CSCI366, CSCI356, CSCI376};
        gameMobDev.addMCores(gameMobDevCores);

        Major softEng = new Major("Software Engineering");
        Subject[] softEngCores={CSCI334, ISIT219, CSCI318, ISIT315};
        softEng.addMCores(softEngCores);

        Major[] BCSMajors = {bigData, cyberSec, digitalSysSec, gameMobDev, softEng};

        Subject[] cCores={CSIT111, CSIT113, CSIT114, CSIT115, CSIT121, CSIT127,
                CSIT128, CSCI235, CSCI251, CSIT214, MATH221, CSCI203, CSIT226, CSIT314, CSIT321};

        Subject[] cEles= {CSCI317, INFO411, CSCI316, ISIT312,CSCI301, CSCI262,
                CSCI369, CSIT302, CSCI361, CSCI368, CSCI376, CSCI236, CSCI336,
                CSCI366, CSCI356, CSCI334, ISIT219, CSCI318, ISIT315};

        Course bcs = new Course("Bachelor of Computer Science");
        bcs.addCores(cCores);
        bcs.addMajors(BCSMajors);
        bcs.addElectives(cEles);

        /****************************************************************/
        Subject CSCI814 = new Subject("CSCI814", "IT Project Management", 6);
        Subject CSCI851 = new Subject("CSCI851", "Advanced Programming", 6);
        Subject CSCI803 = new Subject("CSCI803", "Algorithms and Data Structures", 6);
        Subject CSCI835 = new Subject("CSCI835", "Database Systems", 6);
        Subject MTS9302 = new Subject("MTS9302", "Corporate Network Management", 6);
        Subject CSIT940 = new Subject("CSIT940", "Research Methodology", 6);
        Subject CSCI920 = new Subject("CSCI920", "Contemporary Topics in Computer Science", 6);
        Subject CSCI992 = new Subject("CSCI992", "Professional Project", 12);
        Subject CSCI964 = new Subject("CSCI964", "Computational Intelligence", 6);
        Subject CSCI924 = new Subject("CSCI924", "Reasoning and Learning", 6);
        Subject CSCI944 = new Subject("CSCI944", "Perception and Planning", 6);
        Subject CSCI933 = new Subject("CSCI933", "Machine Learning Algorithms and Applications", 6);
        Subject CSCI935 = new Subject("CSCI935", "Computer Vision Algorithms and Systems", 6);
        Subject CSCI946 = new Subject("CSCI946", "Big Data Analytics", 6);
        Subject CSCI968 = new Subject("CSCI968", "Advanced Network Security", 6);
        Subject INFO912 = new Subject("INFO912", "Mathematics for Cryptography", 6);
        Subject CSCI971 = new Subject("CSCI971", "Advanced Computer Security", 6);
        Subject CSCI910 = new Subject("CSCI910", "Software Requirements, Specifications and Formal Methods", 6);
        Subject CSCI926 = new Subject("CSCI926", "Software Testing and Analysis", 6);
        Subject CSCI927 = new Subject("CSCI927", "Service-Oriented Software Engineering", 6);
        Subject CSCI862 = new Subject("CSCI862", "System Security", 6);
        Subject CSIT826 = new Subject("CSIT826", "Human Computer Interaction", 6);
        Subject ISIT925 = new Subject("ISIT925", "Strategic Network Design", 6);
        Subject ECTE903 = new Subject("ECTE903", "Image and Video Processing", 6);
        Subject INFO911 = new Subject("INFO911", "Data Mining and Knowledge Discovery", 6);
        Subject INFO913 = new Subject("INFO913", "Information Theory", 6);

        Major intelligentSys = new Major("Intelligent System");
        Subject[] iSysCores={CSCI964, CSCI924, CSCI944};
        intelligentSys.addMCores(iSysCores);

        Major mLearningBD = new Major("Machine Learning and Big Data");
        Subject[] mLBDCores={CSCI933, CSCI935, CSCI946};
        mLearningBD.addMCores(mLBDCores);

        Major networkIS = new Major("Network and Information Security");
        Subject[] nwISCores={CSCI968, INFO912, CSCI971};
        networkIS.addMCores(nwISCores);

        Major softwareEng= new Major("Software Engineering");
        Subject[] seCores={CSCI910, CSCI926, CSCI927};
        softwareEng.addMCores(seCores);


        Major[] MCSMajors = {intelligentSys, mLearningBD, networkIS, softwareEng};

        Subject[] mcCores={CSCI814, CSCI851, CSCI803, CSCI835,
                MTS9302, CSIT940, CSCI920, CSCI992};

        Subject[] mcEles= {CSCI862, CSIT826, ISIT925, CSCI964,CSCI924, CSCI944,
                CSCI933, CSCI935, CSCI946, CSCI968, INFO912, CSCI971, CSCI910,
                CSCI926, CSCI927, ECTE903, INFO911, INFO913};

        Course mcs = new Course("Master of Computer Science",96);
        mcs.addCores(mcCores);
        mcs.addMajors(MCSMajors);
        mcs.addElectives(mcEles);


        try {
            ObjectOutputStream ops = new ObjectOutputStream(
                    Files.newOutputStream(Paths.get("bcs.ser"))
            );
            ops.writeObject(bcs);
            ops.flush();
            ops.close();

            ops = new ObjectOutputStream(
                    Files.newOutputStream(Paths.get("mcs.ser"))
            );
            ops.writeObject(mcs);
            ops.flush();
            ops.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
