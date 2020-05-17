import { Component, OnInit, ViewChild, ElementRef, TemplateRef  } from '@angular/core';
import { Headers, Http, RequestOptions, Response , ResponseContentType} from '@angular/http';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import 'rxjs/add/operator/map'
import { GlobalService } from "./global.service";
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { Observable } from 'rxjs';

import Swal from 'sweetalert2'

import $ from "jquery";
import { isNgTemplate } from '@angular/compiler';
import { moment } from 'ngx-bootstrap/chronos/test/chain';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Library-App';
  headers:any;
  modalRef: BsModalRef;
  config = {
    animated: true
  };
  selectedLibraryArr : any = [];
  selectedLibraryNameArr : any = [];
  librariesData:any;
  booksData:any;
  currentLibrary="";

  constructor(public global:GlobalService, public http:Http, private httpClient: HttpClient, private modalService: BsModalService){
  }

  ngOnInit():void{
	this.headers=new HttpHeaders()
                .set('Content-Type','application/json')
                .set('Access-Control-Allow-Credential','true');
    this.getAPI();
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template, this.config);
  }

  getLibrariesAPI() {
	console.log("fetching the api results...");
	let url = "http://localhost:8080/api/libraries"
    return this.http.get(url, {headers: this.headers}).map((res: Response) => res.json());
  }

  getBooksAPI(libraryName) {
	let url = "http://localhost:8080/api/books-by-library/"+libraryName
    return this.http.get(url, {headers: this.headers}).map((res: Response) => res.json());
  }
  
  getAPI() {
    this.getLibrariesAPI().subscribe(data => {
      this.librariesData = data;
    })
   
  }
  refreshData(){
	  this.getAPI();
	  this.getBooksAPI(rowItem.library_name).subscribe(data => {
      this.booksData = data;
    })
	  
  }
  fillBookDetails(rowItem){
	  console.log(this.currentLibrary)
	  document.getElementById("book_title").value=rowItem.title;
	  document.getElementById("book_description").value=rowItem.book_description;
	  document.getElementById("book_author").value=rowItem.author;
  	  document.getElementById("library_name").value=rowItem.library_name;
   	  document.getElementById("book_id").value=rowItem.id;
  }
  saveBook(){
	let payLoad = {};
	payLoad['library_name']=this.currentLibrary;
  	let title=document.getElementById("book_title").value;
	let des=document.getElementById("book_description").value;
    let author=document.getElementById("book_author").value;
	let id=document.getElementById("book_id").value;
	payLoad['title']=title
	payLoad['book_description']=des;
	payLoad['author']=author;

	if (id!=""){
		payLoad['id']=id;
	}
	console.log(payLoad);
	let bookResponseData={};
    let url ="http://localhost:8080/api/book"
    this.http.post(url, payLoad, {headers: this.headers}).map((res: Response) => res.json()).subscribe(data => {
      this.bookResponseData = data;
    });
	Swal.fire("Success", title+' successfully saved.', 'success')
	console.log("response:"+bookResponseData);
  }
  selectRow(rowItem, ind){
   this.currentLibrary=rowItem.library_name
   this.getBooksAPI(rowItem.library_name).subscribe(data => {
      this.booksData = data;
    })
      if(this.librariesData.length > 0){
        for(let i=0;i<this.librariesData.length;i++){
          let rowId = document.getElementById("rowID"+i);
          rowId.style.backgroundColor = "initial";
          rowId.style.color = "initial";
        }
      }
      this.selectedLibraryArr = [];
      this.selectedLibraryNameArr = [];

      let rowId = document.getElementById("rowID"+ind);
      if(this.selectedLibraryNameArr.indexOf(rowItem.tid) == -1){
        this.selectedLibraryArr.push(rowItem);
        this.selectedLibraryNameArr.push(rowItem.tid);
        rowId.style.backgroundColor = "cadetblue";
        rowId.style.color = "#fff";
      }
    console.log(rowItem.library_name);
  }


}
