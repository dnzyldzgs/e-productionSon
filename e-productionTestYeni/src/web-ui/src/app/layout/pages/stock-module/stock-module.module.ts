import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StockModuleComponent } from './stock-module.component';
import {StockModuleRoutingModule} from './stockModule-routing.module';
import {ProductService} from "../../../shared/services/product.service";
import {ApiService} from "../../../shared/services/api.service";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";


@NgModule({
  declarations: [StockModuleComponent],
    imports: [
        CommonModule,
        StockModuleRoutingModule,
        NgxDatatableModule,

    ],
  providers: [ProductService,ApiService]
})
export class StockModuleModule { }

