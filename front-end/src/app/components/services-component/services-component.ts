import { Component, AfterViewInit, OnDestroy, ElementRef, Renderer2 } from '@angular/core';
import { CommonModule, TitleCasePipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
  
interface ServiceItem {
  id: string;
  title: string;
  category: string;
  price: number;
  duration: number;
}

@Component({
  selector: 'app-services-component',
  standalone: true,
  imports: [CommonModule, FormsModule, TitleCasePipe],
  templateUrl: './services-component.html',
  styleUrls: ['./services-component.scss']
})
export class ServicesComponent implements AfterViewInit, OnDestroy {
  categories = ['Todos', 'corte', 'barba', 'combo', 'especial'];
  activeCategory: string = 'Todos';

  // estado para criar novo serviço
  newServiceVisible = false;
  formModel: { title: string; category: string; price: number; duration: number } = {
    title: '',
    category: 'corte',
    price: 0,
    duration: 30
  };

  // declara explicitamente o tipo da lista
  services: ServiceItem[] = [];
  // id do serviço em edição (se houver)
  editingId?: string | null = null;

  private scrollHandler!: () => void;
  constructor(private el: ElementRef, private renderer: Renderer2) {}

  selectCategory(category: string) {
    this.activeCategory = category;
  }

  get filteredServices() {
    if (this.activeCategory === 'Todos') return this.services;
    return this.services.filter(s => s.category === this.activeCategory);
  }

  trackById(index: number, item: ServiceItem) {
    return item.id;
  }

  toggleNew() {
    this.newServiceVisible = !this.newServiceVisible;
    const container = this.el.nativeElement.querySelector('.services-component');
    if (container) {
      if (this.newServiceVisible) {
        this.renderer.addClass(container, 'overlay-open');
      } else {
        this.renderer.removeClass(container, 'overlay-open');
      }
    }
  }

  editService(item: ServiceItem) {
    // abrir formulário preenchido para edição
    this.editingId = item.id;
    this.formModel = {
      title: item.title,
      category: item.category,
      price: item.price,
      duration: item.duration ?? 30
    };
    this.newServiceVisible = true;
  }

  addService() {
    if (!this.formModel.title || this.formModel.price <= 0) {
      alert('Preencha título e preço');
      return;
    }
    if (this.editingId) {
      // atualizar existente
      this.services = this.services.map(s =>
        s.id === this.editingId ? { ...s, title: this.formModel.title, category: this.formModel.category, price: Number(this.formModel.price), duration: Number(this.formModel.duration) } : s
      );
      this.editingId = null;
    } else {
      const newItem: ServiceItem = {
        id: Math.random().toString(36).slice(2),
        title: this.formModel.title,
        category: this.formModel.category,
        price: Number(this.formModel.price),
        duration: Number(this.formModel.duration)
      };
      this.services = [newItem, ...this.services];
    }
    this.formModel = { title: '', category: 'corte', price: 0, duration: 30 };
    this.newServiceVisible = false;
  }

  ngAfterViewInit() {
    const filtroEl = this.el.nativeElement.querySelector('.filtro');
    if (!filtroEl) return;
    const offsetTop = filtroEl.getBoundingClientRect().top + window.scrollY;
    this.scrollHandler = this.renderer.listen('window', 'scroll', () => {
      if (window.scrollY >= offsetTop - 16) {
        this.renderer.addClass(filtroEl, 'fixed');
      } else {
        this.renderer.removeClass(filtroEl, 'fixed');
      }
    });
  }

  ngOnDestroy() {
    if (this.scrollHandler) this.scrollHandler();
  }
}
