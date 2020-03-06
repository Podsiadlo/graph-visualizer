package transform;

import model.*;

public final class Transform2342Closure {
    public static ModelGraph transform(ModelGraph g) {
        Vertex v1 = g.getVertex("n3").get();
        Vertex v2 = g.getVertex("n4").get();
        Vertex v3 = g.getVertex("n2").get();
        Vertex v4 = g.getVertex("n1").get();
        FaceNode t1 = g.getFace("t2").get();
        FaceNode t2 = g.getFace("t1").get();
        FaceNode t3 = g.getFace("t4").get();
        FaceNode t4 = g.getFace("t3").get();

        // refine t1

        // refine vertices
        Coordinates coord5 = v3.getCoordinates().middlePoint(v4.getCoordinates());
        Vertex v5 = g.insertVertex("n5", coord5);

        // refine edges
        g.deleteEdge(v3, v4);
        g.insertEdge("e7", v5, v2, true);
        g.insertEdge("e8", v5, v3, true);
        g.insertEdge("e9", v5, v4, true);

        // refine faces
        g.removeFace(t1.getId());
        g.insertFace("f5", v2, v5, v4);
        g.insertFace("f6", v2, v5, v3);


        // refine t2

        // refine vertices
        Coordinates coord6 = v1.getCoordinates().middlePoint(v4.getCoordinates());
        Vertex v6 = g.insertVertex("n6", coord6);

        Coordinates coord7 = v1.getCoordinates().middlePoint(v3.getCoordinates());
        Vertex v7 = g.insertVertex("n7", coord7);

        // refine edges
        g.deleteEdge(v1, v4);
        g.insertEdge("e10", v1, v6, true);
        g.insertEdge("e11", v4, v6, true);
        g.insertEdge("e12", v3, v6, true);
        g.insertEdge("e13", v5, v6, true);
        g.insertEdge("e14", v7, v6, true);

        g.deleteEdge(v1, v3);
        g.insertEdge("e15", v1, v7, true);
        g.insertEdge("e16", v3, v7, true);

        // refine faces
        g.removeFace(t2.getId());
        g.insertFace("f7", v4, v5, v6);
        g.insertFace("f8", v3, v5, v6);
        g.insertFace("f9", v3, v6, v7);
        g.insertFace("f10", v1, v6, v7);


        // refine t3

        // refine vertices
        Coordinates coord8 = v1.getCoordinates().middlePoint(v2.getCoordinates());
        Vertex v8 = g.insertVertex("n8", coord8);

        // refine edges
        g.deleteEdge(v1, v2);
        g.insertEdge("e17", v1, v8, true);
        g.insertEdge("e18", v2, v8, true);
        g.insertEdge("e19", v4, v8, true);
        g.insertEdge("e20", v6, v8, true);

        // refine faces
        g.removeFace(t3.getId());
        g.insertFace("f11", v1, v6, v8);
        g.insertFace("f12", v4, v6, v8);
        g.insertFace("f13", v2, v4, v8);


        // refine t4

        // refine edges
        g.insertEdge("e21", v2, v7, true);
        g.insertEdge("e22", v7, v8, true);

        // refine faces
        g.removeFace(t4.getId());
        g.insertFace("f14", v2, v3, v7);
        g.insertFace("f15", v2, v7, v8);
        g.insertFace("f16", v1, v7, v8);

        return g;
    }
}
