package com.search.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.search.web.dao.SearchDao;
import com.search.web.model.Document;


@Controller
@PropertySource("classpath:dev.application.properties")
public class SolrSearchController {

	@Resource
	private Environment environment;
	
	@Autowired
	private SearchDao dao;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Start Solr Searching");
		return "index";

	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(@ModelAttribute("searchTerm") String searchTerm, BindingResult result) throws SolrServerException {

		ModelAndView model = new ModelAndView("index");
		model.addObject("lists", solrSearch(searchTerm));
		model.addObject("cognitiveLists", solrCognitiveSearch(searchTerm));
		return model;
	}
	
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public ModelAndView viewDocument(@PathVariable("id") String documentId) {

		ModelAndView model = new ModelAndView("document");
		model.addObject("content", dao.getDocument(documentId));
		return model;
	}

	private List<Document> solrSearch(String searchTerm) throws SolrServerException {
		HttpSolrServer solr = new HttpSolrServer(environment.getRequiredProperty("solr.server.url"));
		SolrQuery query = new SolrQuery();
		query.setQuery(searchTerm); 
		QueryResponse response = solr.query(query);
		List<Document> docs = new ArrayList<>();
		for(SolrDocument doc: response.getResults()) {
			docs.add(new Document(doc.getFieldValue("id").toString(), doc.getFieldValue("name").toString(),
					doc.getFieldValue("features").toString()));
		}
		return docs;
	}
	
	private List<Document> solrCognitiveSearch(String searchTerm) throws SolrServerException {
		HttpSolrServer solr = new HttpSolrServer(environment.getRequiredProperty("solr.server.url"));
		SolrQuery query = new SolrQuery();
		query.setQuery(searchTerm+environment.getRequiredProperty("solr.cognitive.search.param")); 
		QueryResponse response = solr.query(query);
		List<Document> docs = new ArrayList<>();
		for(SolrDocument doc: response.getResults()) {
			docs.add(new Document(doc.getFieldValue("id").toString(), doc.getFieldValue("name").toString(),
					doc.getFieldValue("features").toString()));
		}
		return docs;
	}
}