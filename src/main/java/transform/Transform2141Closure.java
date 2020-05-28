package transform;

import model.*;

public final class Transform2141Closure {

    public static ModelGraph transform(ModelGraph g) {

        Vertex v1 = g.getVertex("n1").get();
        Vertex v2 = g.getVertex("n2").get();
        Vertex v3 = g.getVertex("n3").get();
        Vertex v4 = g.getVertex("n4").get();

        FaceNode t1 = g.getFace("t1").get();
        FaceNode t2 = g.getFace("t2").get();
        FaceNode t3 = g.getFace("t4").get();
        FaceNode t4 = g.getFace("t3").get();


        /* REFINE T1 */
        // vertices
        Coordinates coord5 = v4.getCoordinates().middlePoint(v3.getCoordinates());
        Coordinates coord6 = v2.getCoordinates().middlePoint(v3.getCoordinates());
        Vertex v5 = g.insertVertex("n5", coord5);
        Vertex v6 = g.insertVertex("n6", coord6);

        // edges
        g.deleteEdge(v4, v3);
        g.insertEdge("e7", v5, v2, true);
        g.insertEdge("e8", v5, v4, true);
        g.insertEdge("e9", v5, v3, true);
        g.deleteEdge(v2, v3);
        g.insertEdge("e10", v2, v6, true);
        g.insertEdge("e11", v6, v3, true);
        g.insertEdge("e12", v6, v5, true);

        // faces
        g.removeFace(t1.getId());
        g.insertFace("t5", v2, v5, v4);
        g.insertFace("t6", v2, v5, v6);
        g.insertFace("t7", v6, v5, v3);


        /* REFINE T2 */
        // vertices

        // edges
        g.insertEdge("e13", v5, v1, true);

        // faces
        g.removeFace(t2.getId());
        g.insertFace("t8", v1, v4, v5);
        g.insertFace("t9", v1, v5, v3);


        /* REFINE T3 */
        // vertices
        Coordinates coord7 = v1.getCoordinates().middlePoint(v2.getCoordinates());
        Vertex v7 = g.insertVertex("n7", coord7);

        // edges
        g.deleteEdge(v1, v2);
        g.insertEdge("e14", v2, v7, true);
        g.insertEdge("e15", v1, v7, true);
        g.insertEdge("e16", v7, v4, true);

        // faces
        g.removeFace(t3.getId());
        g.insertFace("t10", v1, v4, v7);
        g.insertFace("t11", v7, v2, v4);


        /* REFINE T4 */
        // vertices

        // edges
        g.insertEdge("e17", v6, v7, true);
        g.insertEdge("e18", v1, v6, true);

        // faces
        g.removeFace(t4.getId());
        g.insertFace("t12", v2, v6, v7);
        g.insertFace("t13", v7, v6, v1);
        g.insertFace("t14", v1, v3, v6);


        /* INTERNAL INSERTIONS */

        // edges
        g.insertEdge("e19", v5, v7, true);

        // faces
        g.insertFace("t15", v1, v7, v5);
        g.insertFace("t16", v2, v5, v7);

        g.insertFace("t17", v4, v5, v7);
        g.insertFace("t18", v5, v6, v7);
        g.insertFace("t19", v1, v5, v6);


        /* INTERNAL TETRAHEDRONS */

        Tetrahedron tet1 = new Tetrahedron(v4, v5, v2, v7);
        Tetrahedron tet2 = new Tetrahedron(v4, v5, v7, v1);
        Tetrahedron tet3 = new Tetrahedron(v5, v6, v3, v1);
        Tetrahedron tet4 = new Tetrahedron(v5, v6, v2, v7);
        Tetrahedron tet5 = new Tetrahedron(v5, v6, v7, v1);

        Tetrahedron[] tetrahedrons = {tet1, tet2, tet3, tet4, tet5};

        return g;
    }

}