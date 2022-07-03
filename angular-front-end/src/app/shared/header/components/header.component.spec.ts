import { ComponentFixture, fakeAsync, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { NavigationEnd, Router, RouterEvent } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { ReplaySubject } from 'rxjs';
import { HeaderComponent } from './header.component';
import { MainNavbarComponent } from './main-navbar/main-navbar.component';
import { SubNavbarComponent } from './sub-navbar/sub-navbar.component';

const eventSubject = new ReplaySubject<RouterEvent>();
const mockRouter = {
    events: eventSubject.asObservable(),
    url: '/'
};

describe('HeaderComponent', () => {
    let fixture: ComponentFixture<HeaderComponent>;
    let component: HeaderComponent;
    let router: Router;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            declarations: [
                HeaderComponent,
                MainNavbarComponent,
                SubNavbarComponent
            ],
            imports:[RouterTestingModule],
            providers: []
        }).compileComponents();
    });

    beforeEach(() => {
        fixture = TestBed.createComponent(HeaderComponent);
        component = fixture.componentInstance;
        router = TestBed.inject(Router);
        fixture.detectChanges();
    });

    describe('HeaderComponent => Should correctly initialize component', () => {
        it('When initialize app it should create the component', () => {
            const fixture = TestBed.createComponent(HeaderComponent);
            const app = fixture.componentInstance;

            expect(app).toBeTruthy();
        });

        describe('HeaderComponent => Should correctly initialize header', () => {
            it('When path is courses it should create main and sub header', fakeAsync(() => {
                component.isCourses = true;
                fixture.detectChanges();
                const headerRows = fixture.debugElement.queryAll(By.css('.main-header'));

                expect(headerRows[0].children.length).toEqual(2);
            }));

            it('When path is not courses it should create main', () => {
                eventSubject.next(new NavigationEnd(1, '/admin', '/admin'));
                const headerRows = fixture.debugElement.queryAll(By.css('.main-header'));

                expect(headerRows[0].children.length).toEqual(1);
            });
        });
    });
});
