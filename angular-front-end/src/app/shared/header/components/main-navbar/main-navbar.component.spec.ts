import { ComponentFixture, TestBed } from "@angular/core/testing";
import { By } from "@angular/platform-browser";
import { RouterTestingModule } from "@angular/router/testing";
import { MainNavbarComponent } from "./main-navbar.component";

describe('MainNavbarComponent', () => {
    let fixture: ComponentFixture<MainNavbarComponent>;
    let component: MainNavbarComponent;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            imports: [RouterTestingModule],
            declarations: [
                MainNavbarComponent
            ]
        }).compileComponents();
    });

    beforeEach(() => {
        fixture = TestBed.createComponent(MainNavbarComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    describe('Should correctly initialize main navbar', () => {
        it('When initialize app it should create the component', () => {
            const fixture = TestBed.createComponent(MainNavbarComponent);
            const app = fixture.componentInstance;

            expect(app).toBeTruthy();
        });
    });

    describe('Should correctly initialize main navigation bar', () => {
        it('When initialize app it should create main navigation bar', () => {
            const mainNavbarRows = fixture.debugElement.queryAll(By.css('.main-navbar'));

            expect(mainNavbarRows[0].children.length).toEqual(5);
        });

        it('When initialize app it should create main navigation logo', () => {
            const mainNavbarRows = fixture.debugElement.queryAll(By.css('.main-navbar'));

            expect(mainNavbarRows[0].children[0].name).toEqual('img');
        });

        describe('Should display each link', () => {

            it('When initialize app it should create main navigation courses link', () => {
                const coursRows = fixture.debugElement.queryAll(By.css('.courses-navbar'));

                expect(coursRows[0].children[0].nativeElement.getAttribute('href')).toEqual('/courses');
            });

            it('When initialize app it should create main navigation admin link', () => {
                const submenuRows = fixture.debugElement.queryAll(By.css('.admin-navbar'));

                expect(submenuRows[0].children[0].nativeElement.getAttribute('href')).toEqual('/admin');
            });

            it('When initialize app it should create main navigation profile link', () => {
                const submenuRows = fixture.debugElement.queryAll(By.css('.profile-navbar'));

                expect(submenuRows[0].children[0].nativeElement.getAttribute('href')).toEqual('/profile');
            });

            it('When initialize app it should create all disconnect link', () => {
                const allCoursesRows = fixture.debugElement.queryAll(By.css('.disconnection-navbar'));

                expect(allCoursesRows[0].children[0].nativeElement.getAttribute('href')).toEqual('/login');
            });
        });

        describe('Should display search input', () => {
            it('When initialize app it should create search input', () => {
                const inputRows = fixture.debugElement.queryAll(By.css('.search-navbar'));

                expect(inputRows[0].children[0].name).toEqual('input');
            });
        });

        describe('Should be stick to the top of the screen', () => {
            it('When scroll down stay sticky to the top', () => {
                const mainNavbarRows = fixture.debugElement.queryAll(By.css('.main-navbar'));
                expect(mainNavbarRows[0].nativeElement.offsetHeight).toEqual(0);
                expect(mainNavbarRows[0].nativeElement.offsetLeft).toEqual(0);
                component.onWindowScroll();
                fixture.detectChanges();

                expect(mainNavbarRows[0].nativeElement.offsetHeight).toEqual(0);
                expect(mainNavbarRows[0].nativeElement.offsetLeft).toEqual(0);
            });
        });
    });
});
