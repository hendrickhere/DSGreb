/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

import java.util.ArrayList;

/**
 *
 * @author hongjun
 */
public class Graph<T extends Comparable<T>,N extends Comparable<N>> {
    
    Vertex<T,N> head;
    int size;

    public Graph(){
        
        head = null;
        size = 0 ;
        
    }
    
    
    public int getSize(){
        return this.size;
    }
    
    
    public boolean hasVertex(T v){        
        if(head == null){
            return false;
        }
        Vertex<T,N> temp = head;
        while(temp != null){
            if( temp.vertexInfo.compareTo(v) == 0){
                return true;
            }
            temp = temp.nextVertex;
        }
        return false;
        
    }
    
    
    
    public int getIndeg(T v){
        if(hasVertex(v) == true){
            Vertex<T,N> temp = head;
            while(temp != null){
                if(temp.vertexInfo.compareTo(v) == 0){
                    return temp.indeg;
                }
                temp = temp.nextVertex;
            }
        }
        return -1;
    }
    
    
    
    public int getOutdeg(T v){
        if(hasVertex(v) == true){
            Vertex<T,N> temp = head;
            while(temp != null){
                if(temp.vertexInfo.compareTo(v) == 0){
                    return temp.outdeg;
                }
            }
            temp = temp.nextVertex;
        }
        return -1;
    }
    
    
    
    
    
    public boolean addVertex(T v){
        if(hasVertex(v) == false){
            Vertex<T,N> temp = head;
            Vertex<T,N> newVertex = new Vertex<>(v, null);
            if(head == null){
                head = newVertex;
            }
            else{
                Vertex<T,N> previous = head;
                while(temp != null){
                    previous = temp;
                    temp = temp.nextVertex;
                }
                previous.nextVertex = newVertex;
            }
            size ++;
            return true;
        }
        else
            return false;
    }
    
    
    
    
    
    public ArrayList<T> getAllVertexObjects(){
        
        ArrayList<T> list = new ArrayList<>();
        Vertex<T,N> temp = head;
        
        while(temp != null){
            list.add(temp.vertexInfo);
            temp = temp.nextVertex;
        }
        return list;    
    }
    
    
    
    
    
    
    public int getIndex(T v){
        Vertex<T,N> temp = head;
        int pos = 0 ; 
        while(temp != null){
            if(temp.vertexInfo.compareTo(v) == 0){
                return pos;
            }
            temp = temp.nextVertex;
            pos+= 1;
        }
        return -1;
    }
    
    
    
    
    
    public T getVertex(int pos){
        if(pos>size -1 || pos<0){
            return null;
        }
        Vertex<T,N> temp = head;
        for(int i = 0 ; i < pos; i++){
            temp = temp.nextVertex;
        }
        return temp.vertexInfo;   
    }
    
    
    
    
    public boolean hasEdge(T source, T destination){
        if(head == null){
            return false;
        }
        if(!hasVertex(source)|| !hasVertex(destination)){
            return false;
        }
        
        Vertex<T,N> sourceVertex = head;
        while(sourceVertex != null){
            if(sourceVertex.vertexInfo.compareTo(source)==0){
                Edge<T,N> currentEdge = sourceVertex.firstEdge;
                while(currentEdge != null){
                    if(currentEdge.toVertex.vertexInfo.compareTo(destination) == 0){
                        return true;
                    }
                    currentEdge = currentEdge.nextEdge;
                }                               
            }
            
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
        
    }
    
    
    
    
    public boolean addEdge(T source, T destination, N w){
        if(head == null){
            return false;
        }
        if(!hasVertex(source) || !hasVertex(destination)){
            return false;
        }
        
        Vertex<T,N> sourceVertex = head;
        while( sourceVertex != null){
            if( sourceVertex.vertexInfo.compareTo(source) == 0){
                Vertex<T,N> destinationVertex = head;
                while(destinationVertex != null){
                    if(destinationVertex.vertexInfo.compareTo(destination) == 0){
                        Edge<T,N> currentEdge = sourceVertex.firstEdge;    // store information;
                        Edge<T,N> newEdge = new Edge<>(destinationVertex, w, currentEdge);
                        sourceVertex.firstEdge = newEdge;
                        sourceVertex.outdeg++;                        
                        destinationVertex.indeg++;
                        return true;

                    }
                    destinationVertex = destinationVertex.nextVertex;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        
        return false;
    }
    
    
    
    
    
    public N getEdgeWeight(T source, T destination){
        N notFound = null;
        if(head == null){
            return notFound;
        }
        if(!hasVertex(source)||!hasVertex(destination)){
            return notFound;
            
        }
        Vertex<T,N> sourceVertex = head;
        while(sourceVertex != null){
            if(sourceVertex.vertexInfo.compareTo(source)==0){
                Edge<T,N> currentEdge = sourceVertex.firstEdge;
                while(currentEdge!=null){
                    if(currentEdge.toVertex.vertexInfo.compareTo(destination) == 0){
                        return currentEdge.weight;
                    }
                    currentEdge = currentEdge.nextEdge;
                }
                
                
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return notFound;
        
    }
            
            
            
    
    
    
    public ArrayList<T> getNeighbours(T v){
        if(!hasVertex(v)){
            return null;
        }
        ArrayList<T> list = new ArrayList<>();
        
        Vertex<T,N> temp = head;
        while(temp != null){
            if(temp.vertexInfo.compareTo(v) == 0){
                Edge<T,N> currentEdge = temp.firstEdge;
                while(currentEdge!= null){
                    list.add(currentEdge.toVertex.vertexInfo);
                    currentEdge = currentEdge.nextEdge;
                }
            }
            temp = temp.nextVertex;    
        }
        return list;
        
    }
            
            
            
    
    public void printEdges(){
        Vertex<T,N> temp = head;
        while(temp != null){
            
            Edge<T,N> currentEdge = temp.firstEdge;
            while(currentEdge != null){
                if(temp.vertexInfo.compareTo(currentEdge.toVertex.vertexInfo)== 0){
                    
                }
                else{
                System.out.print("[" + temp.vertexInfo + " to " + currentEdge.toVertex.vertexInfo +" "+ getEdgeWeight(temp.vertexInfo, currentEdge.toVertex.vertexInfo) + " km"+ "]");
                }
                
                currentEdge = currentEdge.nextEdge;
            }
            System.out.println("");
            temp = temp.nextVertex; 
                
        }
        
        
        
    }
    
    
 
    
    public boolean addUndirectedEdge(T source, T destination, N weight){
        return(addEdge(source,destination,weight) && addEdge(destination, source, weight));
    }
    
 
    
    public Edge<T,N> removeEdge(T source, T destination){
        if(!hasVertex(source) || !hasVertex(destination)){
            return null;
        }
        if(head == null){
            return null;
        }
        Vertex<T,N> sourceVertex = head;
        while(sourceVertex!= null){
            if(sourceVertex.vertexInfo.compareTo(source) == 0){
                // reach source
                Edge<T,N> currentEdge = sourceVertex.firstEdge;
                Edge<T,N> previous = sourceVertex.firstEdge;
                while(currentEdge != null){
                    if(currentEdge.toVertex.vertexInfo.compareTo(destination) == 0){
                        sourceVertex.firstEdge = currentEdge.nextEdge;   //previous.nextEdge = currentEdge.nextEdge;
                        sourceVertex.outdeg--;
                        currentEdge.toVertex.indeg--;
                        currentEdge.toVertex = null;
                        currentEdge.nextEdge = null;
                        size --;
                        return currentEdge;
                    }
                                                                       // previous = currentEdge;
                    currentEdge = currentEdge.nextEdge;
                }
                    
                
                
                
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        
            
        return null;
    }
    
    
}
