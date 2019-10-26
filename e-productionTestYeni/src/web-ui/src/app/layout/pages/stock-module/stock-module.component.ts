import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../../shared/services/product.service";
import {Page} from "../../../common/page";

@Component({
  selector: 'app-stock-module',
  templateUrl: './stock-module.component.html',
  styleUrls: ['./stock-module.component.scss'],
})

export class StockModuleComponent implements OnInit {

  page = new Page();

  cols = [
    {prop: 'id', name: 'No'},
    {prop: 'productCategory', name: 'Product Category', sortable: false},
    {prop: 'productCode', name: 'Product Code', sortable: false},
    {prop: 'productName', name: 'Product Name', sortable: false},
    {prop: 'productPrice', name: 'Price', sortable: false} ];
  rows = [];

  constructor(private productService: ProductService) {}

  ngOnInit() {

    this.setPage({offset: 0});
  }

  setPage(pageInfo) {
    this.page.page = pageInfo.offset;
    this.productService.getAllPageable(this.page).subscribe(pagedData => {
      this.page.size = pagedData.size;
      this.page.page = pagedData.page;
      this.page.totalElements = pagedData.totalElements;
      this.rows = pagedData.content;
    });
  }










 /* constructor(private http: HttpClient) {
  }

(createConfirm)="addRecord($event)"
                     (editConfirm)="updateRecord($event)"
                     (deleteConfirm)="deleteRecord($event)"
  data:any = [];

  ngOnInit(): void {

    this.http.get<ApiService>('http://localhost:8000/api/product').subscribe(
        data => {
          this.data = data;
          console.log(this.data);
        },
        (err: HttpErrorResponse) => {
          if (err.error instanceof Error) {
            console.log("Client-side error occured.");
          } else {
            console.log("Server-side error occured.");
          }
        });
  }

  settings = {
    add:{
      confirmCreate:true,

    },
    edit:{
      confirmSave:true
    },
    delete :{
      confirmDelete: true
    },

    columns: {
      id: {
        title: 'ID',
        filter: false,
        editable: false,
        addable:false,
      },
      Category: {
        title: 'Category',
        filter: true
      },
      Product: {
        title: 'Product Name',
        filter: true
      },
      Price: {
        title: 'Price',
        filter: true
      }
    }
  };

  addRecord(event) {

    var data = {"id" : event.newData.id,
      "Category" : event.newData.Category,
      "Product" : event.newData.Product,
      "Price" : event.newData.Price
    };

    this.http.post<ApiService>('http://localhost:8000/api/product/', data).subscribe(
        res => {
          console.log(res);
          event.confirm.resolve(event.newData);
        },
        (err: HttpErrorResponse) => {
          if (err.error instanceof Error) {
            console.log("Client-side error occured.");
          } else {
            console.log("Server-side error occured.");
          }
        });
  }

  deleteRecord(event){
    console.log(event.data);

    this.http.delete<any>('http://localhost:8000/api/product'+event.data.id).subscribe(
        res => {
          console.log(res);
          event.confirm.resolve(event.source.data);
        },
        (err: HttpErrorResponse) => {
          if (err.error instanceof Error) {
            console.log("Client-side error occured.");
          } else {
            console.log("Server-side error occured.");
          }
        });
    //event.confirm.resolve(event.source.data);

  }

  updateRecord(event) {
    console.log('ddddd');
    var data = {"id" : event.newData.id,
      "Category" : event.newData.Category,
      "Product" : event.newData.Product,
      "Price" : event.newData.Price
    };

    this.http.put<ApiService>('http://localhost:8000/api/product'+event.newData.id, data).subscribe(
        res => {
          console.log(res);
          event.confirm.resolve(event.newData);
        },
        (err: HttpErrorResponse) => {
          if (err.error instanceof Error) {
            console.log("Client-side error occured.");
          } else {
            console.log("Server-side error occured.");
          }
        });
  }*/


/*  --default ng2 smart table codes---
constructor(){}


  settings = {

    columns: {
      id: {
        title: 'ID',
        // filter: false,
        editable: false,
        addable:false,
        autoIncrement: false,
      },
      Category: {
        title: 'Category',
        filter: true
      },
      Product: {
        title: 'Product Name',
        filter: true
      },
      Price: {
        title: 'Price',
        filter: true
      }
    }
  };


  data = [
    {
      id: 1,
      Category: 'Computer',
      Product: 'MacBook',
      Price: '10$'
    },
    {
      id: 2,
      Category: 'Techical Staff',
      Product: 'Regulator',
      Price: '20$'
    },
    {
      id: 3,
      Category: 'Other',
      Product: 'iPhone',
      Price: '100$'
    },
    {
      id: 4,
      Category: 'Electronic',
      Product: 'Samsung SSD',
      Price: '300$'
    },
    {
      id: 5,
      Category: 'Other',
      Product: 'SD Card',
      Price: '50$'
    },
    {
      id: 6,
      Category: 'Other',
      Product: 'iPhone 11 Pro',
      Price: '100$'
    },
    {
      id: 7,
      Category: 'Test Category',
      Product: 'Test Product',
      Price: '1$'
    },
    ,
    {
      id: 8,
      Category: 'Test Category',
      Product: 'Test Product',
      Price: '1$'
    },
    {
      id: 9,
      Category: 'Test Category',
      Product: 'Test Product',
      Price: '1$'
    },
    {
      id: 10,
      Category: 'Test Category',
      Product: 'Test Product',
      Price: '1$'
    },
    {
      id: 11,
      Category: 'Test Category',
      Product: 'Test Product',
      Price: '1$'
    }
  ];

  ngOnInit() {}*/

}
