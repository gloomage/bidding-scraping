package com.bidding.services;

import com.bidding.models.LiciModel;
import com.bidding.models.SiteModel;
import com.bidding.repositories.SiteRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SiteService {

    final SiteRepository siteRepository;

    public SiteService(SiteRepository siteRepository){
        this.siteRepository = siteRepository;
    }

    public List<SiteModel> findAll() {
        return siteRepository.findAll();
    }

    @Transactional
    public SiteModel save(SiteModel siteModel) {
        return siteRepository.save(siteModel);
    }

    public Optional<SiteModel> findById(UUID id) {
        return siteRepository.findById(id);
    }

    @Transactional
    public void delete(SiteModel siteModel) {
        siteRepository.delete(siteModel);
    }

    public List<LiciModel> extrairLicitacoes(SiteModel siteModel) throws IOException {

        /* Pegando a pagina com JSOUP */
        Document doc = Jsoup.connect(siteModel.getUrlsite().toString()).get();

        /* Class da Grid */
        Element table = doc.getElementsByClass("row-fluid").first();

        /* Corpo da Grid pela TAG */
        Element tbody = table.getElementsByTag("tbody").first();

        /* TAG dos objetos */
        List<Element> licitacoes1 = tbody.getElementsByTag("tr");

        /* Criando nova lista pra armazenas as licitações */
        List<LiciModel> licitacoes2 = new ArrayList<>();

        //Criando as licitações
        for(Element licitacao : licitacoes1){

            /* TAG final de cada elemento */
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
