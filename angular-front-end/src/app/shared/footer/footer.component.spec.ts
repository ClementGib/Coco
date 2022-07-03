import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { RouterTestingModule } from '@angular/router/testing';
import { Observable, of } from 'rxjs';
import { VersionService } from '../../core/sevices/REST/version/version.service';
import { FooterComponent } from './footer.component';

const mockVersionService = {
    getVersion: jest.fn()
};

describe('FooterComponent', () => {
    let fixture: ComponentFixture<FooterComponent>;
    let component: FooterComponent;
    let versionService: VersionService;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            imports: [RouterTestingModule],
            declarations: [
                FooterComponent
            ],
            providers: [
                { provide: VersionService, useValue: mockVersionService }
            ]
        }).compileComponents();
    });

    beforeEach(() => {
        fixture = TestBed.createComponent(FooterComponent);
        component = fixture.componentInstance;
        jest.spyOn(mockVersionService, 'getVersion').mockReturnValue(of("1.0"));
    });

    describe('FooterComponent => Should correctly initialize footer', () => {
        it('When initialize app it should create the component', () => {
            const fixture = TestBed.createComponent(FooterComponent);
            const app = fixture.componentInstance;

            expect(app).toBeTruthy();
        });

        describe('FooterComponent => Should correctly initialize links', () => {
            it('When initialize app it should create social links', () => {
                fixture.detectChanges();
                const socialRows = fixture.debugElement.queryAll(By.css('.social-footer'));

                expect(socialRows[0].children.length).toEqual(4);
            });

            it('When initialize app it should create twitter link', () => {
                fixture.detectChanges();
                const twitterLink = fixture.debugElement.queryAll(By.css('.twitter-link'));

                expect(twitterLink[0].nativeElement.getAttribute('href')).toEqual('https://twitter.com/CDXitech');
            });

            it('When initialize app it should create linkedin link', () => {
                fixture.detectChanges();
                const linkedinLink = fixture.debugElement.queryAll(By.css('.linkedin-link'));

                expect(linkedinLink[0].nativeElement.getAttribute('href')).toEqual('https://www.linkedin.com/in/cl%C3%A9ment-gibert-7012');
            });

            it('When initialize app it should create github link', () => {
                fixture.detectChanges();
                const githubLink = fixture.debugElement.queryAll(By.css('.github-link'));

                expect(githubLink[0].nativeElement.getAttribute('href')).toEqual('https://github.com/ClementGib/ClementGib');
            });

            it('When initialize app it should create email link', () => {
                fixture.detectChanges();
                const emailLink = fixture.debugElement.queryAll(By.css('.email-link'));

                expect(emailLink[0].nativeElement.getAttribute('href')).toEqual('mailto:cdx.it.contact@gmail.com');
            });
        });

        describe('FooterComponent => Should correctly initialize sections', () => {
            it('When initialize app it should create section links', () => {
                fixture.detectChanges();
                const sectionRows = fixture.debugElement.queryAll(By.css('.section-footer'));

                expect(sectionRows[0].children.length).toEqual(3);
            });

            it('When initialize app it should create login section', () => {
                fixture.detectChanges();
                const sectionRows = fixture.debugElement.queryAll(By.css('.section-footer'));

                expect(sectionRows[0].children[0].nativeElement.getAttribute('href')).toEqual('/login');
            });

            it('When initialize app it should create courses section', () => {
                fixture.detectChanges();
                const sectionRows = fixture.debugElement.queryAll(By.css('.section-footer'));

                expect(sectionRows[0].children[1].nativeElement.getAttribute('href')).toEqual('/courses');
            });

            it('When initialize app it should create profile section', () => {
                fixture.detectChanges();
                const sectionRows = fixture.debugElement.queryAll(By.css('.section-footer'));
                expect(sectionRows[0].children[2].nativeElement.getAttribute('href')).toEqual('/profile');
            });
        });

        describe('FooterComponent => Should correctly initialize sub footer', () => {
            it('When initialize app it should create sub footer', () => {
                fixture.detectChanges();
                const subFooterRows = fixture.debugElement.queryAll(By.css('.sub-footer'));

                expect(subFooterRows[0].children.length).toEqual(2);
            });

            it('When initialize app it should create login section', () => {
                fixture.detectChanges();
                const subFooterRows = fixture.debugElement.queryAll(By.css('.sub-footer'));

                expect(subFooterRows[0].children[0].nativeElement.innerHTML).toEqual('Powered by CDX 2022');
            });

            it('When initialize app it should create login section', () => {
                fixture.detectChanges();
                const subFooterRows = fixture.debugElement.queryAll(By.css('.sub-footer'));

                expect(subFooterRows[0].children[1].nativeElement.innerHTML).toEqual('Version: 1.0');
            });
        });
    });
});
