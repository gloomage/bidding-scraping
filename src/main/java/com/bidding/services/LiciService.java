package com.bidding.services;

import com.bidding.models.LiciModel;
import com.bidding.repositories.LiciRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LiciService {

    final LiciRepository liciRepository;

    public LiciService(LiciRepository liciRepository){
        this.liciRepository = liciRepository;
    }

    public List<LiciModel> extrairLicitacoes() throws IOException {

        /* URL do site */
        String url = "https://portaldatransparencia.barreiras.ba.gov.br/licitacoes/";

        /* Pegando a pagina com JSOUP */
        Document doc = Jsoup.connect(url).get();

        /* Escolhendo o elemento com base no nome da class */
        Element table = doc.getElementsByClass("row-fluid").first();

        /* Pegando apenas o conteudo com base na TAG*/
        Element tbody = table.getElementsByTag("tbody").first();

        /* Criando uma lista com as tags tr */
        List<Element> licitacoes1 = tbody.getElementsByTag("tr");

        System.out.println(licitacoes1);

        /* Criando nova lista pra armazenas as licitações */
        List<LiciModel> licitacoes2 = new ArrayList<>();

        //Criando as licitações
        for(Element licitacao : licitacoes1){

            List<Element> attributes = licitacao.getElementsByTag("td");
            var liciModel = new LiciModel();
            liciModel.setData(attributes.get(0).text());
            liciModel.setTitulo(attributes.get(1).text());
            liciModel.setObjeto(attributes.get(2).text());
            liciModel.setMes(attributes.get(3).text());
            liciModel.setAno(attributes.get(4).text());
            liciModel.setTipo(attributes.get(5).text());
            liciModel.setModalidade(attributes.get(6).text());
            liciModel.setLink(attributes.get(7).text());

            licitacoes2.add(liciModel);
        }

        return licitacoes2;
    }
}
