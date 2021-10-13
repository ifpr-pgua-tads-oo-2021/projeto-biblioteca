package ifpr.pgua.eic.biblioteca.repositorios;

import java.util.ArrayList;

import ifpr.pgua.eic.biblioteca.modelos.Autor;
import ifpr.pgua.eic.biblioteca.modelos.ItemAcervo;
import ifpr.pgua.eic.biblioteca.modelos.Livro;
import ifpr.pgua.eic.biblioteca.modelos.Revista;

public class Biblioteca {
    
    private ArrayList<Autor> autores;
    private ArrayList<ItemAcervo> acervo;

    public Biblioteca(){
        autores = new ArrayList<>();
        acervo = new ArrayList<>();
    }

    public Autor buscaAutorNome(String nome){
        return autores.stream().filter(a -> a.getNome().equals(nome)).findAny().orElseGet(()->null);
    }

    public Autor buscaAutorCpf(String cpf){
        return autores.stream().filter(a -> a.getCpf().equals(cpf)).findFirst().orElseGet(()->null);
    }

    public boolean cadastraAutor(String nome, String email, String cpf){
        Autor a = new Autor(nome, email, cpf);

        if(buscaAutorCpf(cpf)==null){
            autores.add(a);
            return true;
        }
        return false;
    }

    public ItemAcervo buscaItemAcervo(String titulo){
        return acervo.stream().filter(a -> a.getTitulo().equals(titulo)).findAny().orElseGet(()->null);
    }

    public ItemAcervo buscaItemAcervo(String titulo, int numero){

        for(ItemAcervo a:acervo){
            if(a instanceof Revista){
                Revista r = (Revista)a;
                if(r.getNumero()==numero && r.getTitulo().equals(titulo)){
                    return r;
                }
            }
        }
        return null;
    }

    public boolean cadastraLivro(String titulo, Autor a, int anoPublicacao, int numeroPaginas, String editora, int numeroCapitulos){
        if(buscaItemAcervo(titulo) == null){
            Livro l = new Livro(titulo, a, anoPublicacao, numeroPaginas, editora, numeroCapitulos);
            acervo.add(l);
            return true;
        }

        return false;
    }

    public boolean cadastraRevista(String titulo, int numero, int anoPublicacao, int numeroPaginas, String editora){
        if(buscaItemAcervo(titulo,numero) == null){
            Revista r = new Revista(titulo, numero, anoPublicacao, numeroPaginas, editora);
            acervo.add(r);
            return true;
        }

        return false;
    }

    public ArrayList<Autor> getAutores(){
        return autores;
    }

    public ArrayList<Livro> getLivros(){
        ArrayList<Livro> livros = new ArrayList<>();

        for(ItemAcervo a:acervo){
            if(a instanceof Livro){
                livros.add((Livro)a);
            }
        }
        return livros;
    }

    public ArrayList<Revista> getRevistas(){
        ArrayList<Revista> revistas = new ArrayList<>();

        for(ItemAcervo a:acervo){
            if(a instanceof Revista){
                revistas.add((Revista)a);
            }
        }
        return revistas;
    }






}
