/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

/**
 *
 * @author hongjun
 */
public class Vertex <T extends Comparable<T>,N extends Comparable<N>> {
    T vertexInfo;  // E element;
    int indeg;
    int outdeg;
    Vertex<T,N> nextVertex;
    Edge<T,N> firstEdge;
    
    

    public Vertex() {
        this.vertexInfo = null;     // Cannot put this.vertexInfo
        indeg = 0;
        outdeg = 0;
        nextVertex = null;     // Cannot put this.nextVertex;
        firstEdge = null;
    
    }

    public Vertex(T vInfo, Vertex<T, N> next) {    // cannot same name
        vertexInfo = vInfo;
        indeg = 0;
        outdeg = 0;
        nextVertex = next;
        firstEdge = null;
    }
}
