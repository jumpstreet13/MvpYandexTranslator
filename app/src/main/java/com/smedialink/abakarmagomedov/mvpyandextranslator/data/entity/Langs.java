package com.smedialink.abakarmagomedov.mvpyandextranslator.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by abakarmagomedov on 31/05/17.
 */

public class Langs{

    @SerializedName("af")
    @Expose
    private String af;
    @SerializedName("am")
    @Expose
    private String am;
    @SerializedName("ar")
    @Expose
    private String ar;
    @SerializedName("az")
    @Expose
    private String az;
    @SerializedName("ba")
    @Expose
    private String ba;
    @SerializedName("be")
    @Expose
    private String be;
    @SerializedName("bg")
    @Expose
    private String bg;
    @SerializedName("bn")
    @Expose
    private String bn;
    @SerializedName("bs")
    @Expose
    private String bs;
    @SerializedName("ca")
    @Expose
    private String ca;
    @SerializedName("ceb")
    @Expose
    private String ceb;
    @SerializedName("cs")
    @Expose
    private String cs;
    @SerializedName("cy")
    @Expose
    private String cy;
    @SerializedName("da")
    @Expose
    private String da;
    @SerializedName("de")
    @Expose
    private String de;
    @SerializedName("el")
    @Expose
    private String el;
    @SerializedName("en")
    @Expose
    private String en;
    @SerializedName("eo")
    @Expose
    private String eo;
    @SerializedName("es")
    @Expose
    private String es;
    @SerializedName("et")
    @Expose
    private String et;
    @SerializedName("eu")
    @Expose
    private String eu;
    @SerializedName("fa")
    @Expose
    private String fa;
    @SerializedName("fi")
    @Expose
    private String fi;
    @SerializedName("fr")
    @Expose
    private String fr;
    @SerializedName("ga")
    @Expose
    private String ga;
    @SerializedName("gd")
    @Expose
    private String gd;
    @SerializedName("gl")
    @Expose
    private String gl;
    @SerializedName("gu")
    @Expose
    private String gu;
    @SerializedName("he")
    @Expose
    private String he;
    @SerializedName("hi")
    @Expose
    private String hi;
    @SerializedName("hr")
    @Expose
    private String hr;
    @SerializedName("ht")
    @Expose
    private String ht;
    @SerializedName("hu")
    @Expose
    private String hu;
    @SerializedName("hy")
    @Expose
    private String hy;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("is")
    @Expose
    private String is;
    @SerializedName("it")
    @Expose
    private String it;
    @SerializedName("ja")
    @Expose
    private String ja;
    @SerializedName("jv")
    @Expose
    private String jv;
    @SerializedName("ka")
    @Expose
    private String ka;
    @SerializedName("kk")
    @Expose
    private String kk;
    @SerializedName("km")
    @Expose
    private String km;
    @SerializedName("kn")
    @Expose
    private String kn;
    @SerializedName("ko")
    @Expose
    private String ko;
    @SerializedName("ky")
    @Expose
    private String ky;
    @SerializedName("la")
    @Expose
    private String la;
    @SerializedName("lb")
    @Expose
    private String lb;
    @SerializedName("lo")
    @Expose
    private String lo;
    @SerializedName("lt")
    @Expose
    private String lt;
    @SerializedName("lv")
    @Expose
    private String lv;
    @SerializedName("mg")
    @Expose
    private String mg;
    @SerializedName("mhr")
    @Expose
    private String mhr;
    @SerializedName("mi")
    @Expose
    private String mi;
    @SerializedName("mk")
    @Expose
    private String mk;
    @SerializedName("ml")
    @Expose
    private String ml;
    @SerializedName("mn")
    @Expose
    private String mn;
    @SerializedName("mr")
    @Expose
    private String mr;
    @SerializedName("mrj")
    @Expose
    private String mrj;
    @SerializedName("ms")
    @Expose
    private String ms;
    @SerializedName("mt")
    @Expose
    private String mt;
    @SerializedName("my")
    @Expose
    private String my;
    @SerializedName("ne")
    @Expose
    private String ne;
    @SerializedName("nl")
    @Expose
    private String nl;
    @SerializedName("no")
    @Expose
    private String no;
    @SerializedName("pa")
    @Expose
    private String pa;
    @SerializedName("pap")
    @Expose
    private String pap;
    @SerializedName("pl")
    @Expose
    private String pl;
    @SerializedName("pt")
    @Expose
    private String pt;
    @SerializedName("ro")
    @Expose
    private String ro;
    @SerializedName("ru")
    @Expose
    private String ru;
    @SerializedName("si")
    @Expose
    private String si;
    @SerializedName("sk")
    @Expose
    private String sk;
    @SerializedName("sl")
    @Expose
    private String sl;
    @SerializedName("sq")
    @Expose
    private String sq;
    @SerializedName("sr")
    @Expose
    private String sr;
    @SerializedName("su")
    @Expose
    private String su;
    @SerializedName("sv")
    @Expose
    private String sv;
    @SerializedName("sw")
    @Expose
    private String sw;
    @SerializedName("ta")
    @Expose
    private String ta;
    @SerializedName("te")
    @Expose
    private String te;
    @SerializedName("tg")
    @Expose
    private String tg;
    @SerializedName("th")
    @Expose
    private String th;
    @SerializedName("tl")
    @Expose
    private String tl;
    @SerializedName("tr")
    @Expose
    private String tr;
    @SerializedName("tt")
    @Expose
    private String tt;
    @SerializedName("udm")
    @Expose
    private String udm;
    @SerializedName("uk")
    @Expose
    private String uk;
    @SerializedName("ur")
    @Expose
    private String ur;
    @SerializedName("uz")
    @Expose
    private String uz;
    @SerializedName("vi")
    @Expose
    private String vi;
    @SerializedName("xh")
    @Expose
    private String xh;
    @SerializedName("yi")
    @Expose
    private String yi;
    @SerializedName("zh")
    @Expose
    private String zh;

    public String getAf() {
        return af;
    }

    public void setAf(String af) {
        this.af = af;
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

    public String getAz() {
        return az;
    }

    public void setAz(String az) {
        this.az = az;
    }

    public String getBa() {
        return ba;
    }

    public void setBa(String ba) {
        this.ba = ba;
    }

    public String getBe() {
        return be;
    }

    public void setBe(String be) {
        this.be = be;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public String getBn() {
        return bn;
    }

    public void setBn(String bn) {
        this.bn = bn;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public String getCeb() {
        return ceb;
    }

    public void setCeb(String ceb) {
        this.ceb = ceb;
    }

    public String getCs() {
        return cs;
    }

    public void setCs(String cs) {
        this.cs = cs;
    }

    public String getCy() {
        return cy;
    }

    public void setCy(String cy) {
        this.cy = cy;
    }

    public String getDa() {
        return da;
    }

    public void setDa(String da) {
        this.da = da;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getEl() {
        return el;
    }

    public void setEl(String el) {
        this.el = el;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getEo() {
        return eo;
    }

    public void setEo(String eo) {
        this.eo = eo;
    }

    public String getEs() {
        return es;
    }

    public void setEs(String es) {
        this.es = es;
    }

    public String getEt() {
        return et;
    }

    public void setEt(String et) {
        this.et = et;
    }

    public String getEu() {
        return eu;
    }

    public void setEu(String eu) {
        this.eu = eu;
    }

    public String getFa() {
        return fa;
    }

    public void setFa(String fa) {
        this.fa = fa;
    }

    public String getFi() {
        return fi;
    }

    public void setFi(String fi) {
        this.fi = fi;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getGa() {
        return ga;
    }

    public void setGa(String ga) {
        this.ga = ga;
    }

    public String getGd() {
        return gd;
    }

    public void setGd(String gd) {
        this.gd = gd;
    }

    public String getGl() {
        return gl;
    }

    public void setGl(String gl) {
        this.gl = gl;
    }

    public String getGu() {
        return gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }

    public String getHe() {
        return he;
    }

    public void setHe(String he) {
        this.he = he;
    }

    public String getHi() {
        return hi;
    }

    public void setHi(String hi) {
        this.hi = hi;
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    public String getHt() {
        return ht;
    }

    public void setHt(String ht) {
        this.ht = ht;
    }

    public String getHu() {
        return hu;
    }

    public void setHu(String hu) {
        this.hu = hu;
    }

    public String getHy() {
        return hy;
    }

    public void setHy(String hy) {
        this.hy = hy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIs() {
        return is;
    }

    public void setIs(String is) {
        this.is = is;
    }

    public String getIt() {
        return it;
    }

    public void setIt(String it) {
        this.it = it;
    }

    public String getJa() {
        return ja;
    }

    public void setJa(String ja) {
        this.ja = ja;
    }

    public String getJv() {
        return jv;
    }

    public void setJv(String jv) {
        this.jv = jv;
    }

    public String getKa() {
        return ka;
    }

    public void setKa(String ka) {
        this.ka = ka;
    }

    public String getKk() {
        return kk;
    }

    public void setKk(String kk) {
        this.kk = kk;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getKn() {
        return kn;
    }

    public void setKn(String kn) {
        this.kn = kn;
    }

    public String getKo() {
        return ko;
    }

    public void setKo(String ko) {
        this.ko = ko;
    }

    public String getKy() {
        return ky;
    }

    public void setKy(String ky) {
        this.ky = ky;
    }

    public String getLa() {
        return la;
    }

    public void setLa(String la) {
        this.la = la;
    }

    public String getLb() {
        return lb;
    }

    public void setLb(String lb) {
        this.lb = lb;
    }

    public String getLo() {
        return lo;
    }

    public void setLo(String lo) {
        this.lo = lo;
    }

    public String getLt() {
        return lt;
    }

    public void setLt(String lt) {
        this.lt = lt;
    }

    public String getLv() {
        return lv;
    }

    public void setLv(String lv) {
        this.lv = lv;
    }

    public String getMg() {
        return mg;
    }

    public void setMg(String mg) {
        this.mg = mg;
    }

    public String getMhr() {
        return mhr;
    }

    public void setMhr(String mhr) {
        this.mhr = mhr;
    }

    public String getMi() {
        return mi;
    }

    public void setMi(String mi) {
        this.mi = mi;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getMl() {
        return ml;
    }

    public void setMl(String ml) {
        this.ml = ml;
    }

    public String getMn() {
        return mn;
    }

    public void setMn(String mn) {
        this.mn = mn;
    }

    public String getMr() {
        return mr;
    }

    public void setMr(String mr) {
        this.mr = mr;
    }

    public String getMrj() {
        return mrj;
    }

    public void setMrj(String mrj) {
        this.mrj = mrj;
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public String getMt() {
        return mt;
    }

    public void setMt(String mt) {
        this.mt = mt;
    }

    public String getMy() {
        return my;
    }

    public void setMy(String my) {
        this.my = my;
    }

    public String getNe() {
        return ne;
    }

    public void setNe(String ne) {
        this.ne = ne;
    }

    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa;
    }

    public String getPap() {
        return pap;
    }

    public void setPap(String pap) {
        this.pap = pap;
    }

    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }

    public String getPt() {
        return pt;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }

    public String getRo() {
        return ro;
    }

    public void setRo(String ro) {
        this.ro = ro;
    }

    public String getRu() {
        return ru;
    }

    public void setRu(String ru) {
        this.ru = ru;
    }

    public String getSi() {
        return si;
    }

    public void setSi(String si) {
        this.si = si;
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    public String getSq() {
        return sq;
    }

    public void setSq(String sq) {
        this.sq = sq;
    }

    public String getSr() {
        return sr;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }

    public String getSu() {
        return su;
    }

    public void setSu(String su) {
        this.su = su;
    }

    public String getSv() {
        return sv;
    }

    public void setSv(String sv) {
        this.sv = sv;
    }

    public String getSw() {
        return sw;
    }

    public void setSw(String sw) {
        this.sw = sw;
    }

    public String getTa() {
        return ta;
    }

    public void setTa(String ta) {
        this.ta = ta;
    }

    public String getTe() {
        return te;
    }

    public void setTe(String te) {
        this.te = te;
    }

    public String getTg() {
        return tg;
    }

    public void setTg(String tg) {
        this.tg = tg;
    }

    public String getTh() {
        return th;
    }

    public void setTh(String th) {
        this.th = th;
    }

    public String getTl() {
        return tl;
    }

    public void setTl(String tl) {
        this.tl = tl;
    }

    public String getTr() {
        return tr;
    }

    public void setTr(String tr) {
        this.tr = tr;
    }

    public String getTt() {
        return tt;
    }

    public void setTt(String tt) {
        this.tt = tt;
    }

    public String getUdm() {
        return udm;
    }

    public void setUdm(String udm) {
        this.udm = udm;
    }

    public String getUk() {
        return uk;
    }

    public void setUk(String uk) {
        this.uk = uk;
    }

    public String getUr() {
        return ur;
    }

    public void setUr(String ur) {
        this.ur = ur;
    }

    public String getUz() {
        return uz;
    }

    public void setUz(String uz) {
        this.uz = uz;
    }

    public String getVi() {
        return vi;
    }

    public void setVi(String vi) {
        this.vi = vi;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getYi() {
        return yi;
    }

    public void setYi(String yi) {
        this.yi = yi;
    }

    public String getZh() {
        return zh;
    }

    public void setZh(String zh) {
        this.zh = zh;
    }

    @Override
    public String toString() {
        return
                "af='" + af + '\'' +
                ", am='" + am + '\'' +
                ", ar='" + ar + '\'' +
                ", az='" + az + '\'' +
                ", ba='" + ba + '\'' +
                ", be='" + be + '\'' +
                ", bg='" + bg + '\'' +
                ", bn='" + bn + '\'' +
                ", bs='" + bs + '\'' +
                ", ca='" + ca + '\'' +
                ", ceb='" + ceb + '\'' +
                ", cs='" + cs + '\'' +
                ", cy='" + cy + '\'' +
                ", da='" + da + '\'' +
                ", de='" + de + '\'' +
                ", el='" + el + '\'' +
                ", en='" + en + '\'' +
                ", eo='" + eo + '\'' +
                ", es='" + es + '\'' +
                ", et='" + et + '\'' +
                ", eu='" + eu + '\'' +
                ", fa='" + fa + '\'' +
                ", fi='" + fi + '\'' +
                ", fr='" + fr + '\'' +
                ", ga='" + ga + '\'' +
                ", gd='" + gd + '\'' +
                ", gl='" + gl + '\'' +
                ", gu='" + gu + '\'' +
                ", he='" + he + '\'' +
                ", hi='" + hi + '\'' +
                ", hr='" + hr + '\'' +
                ", ht='" + ht + '\'' +
                ", hu='" + hu + '\'' +
                ", hy='" + hy + '\'' +
                ", id='" + id + '\'' +
                ", is='" + is + '\'' +
                ", it='" + it + '\'' +
                ", ja='" + ja + '\'' +
                ", jv='" + jv + '\'' +
                ", ka='" + ka + '\'' +
                ", kk='" + kk + '\'' +
                ", km='" + km + '\'' +
                ", kn='" + kn + '\'' +
                ", ko='" + ko + '\'' +
                ", ky='" + ky + '\'' +
                ", la='" + la + '\'' +
                ", lb='" + lb + '\'' +
                ", lo='" + lo + '\'' +
                ", lt='" + lt + '\'' +
                ", lv='" + lv + '\'' +
                ", mg='" + mg + '\'' +
                ", mhr='" + mhr + '\'' +
                ", mi='" + mi + '\'' +
                ", mk='" + mk + '\'' +
                ", ml='" + ml + '\'' +
                ", mn='" + mn + '\'' +
                ", mr='" + mr + '\'' +
                ", mrj='" + mrj + '\'' +
                ", ms='" + ms + '\'' +
                ", mt='" + mt + '\'' +
                ", my='" + my + '\'' +
                ", ne='" + ne + '\'' +
                ", nl='" + nl + '\'' +
                ", no='" + no + '\'' +
                ", pa='" + pa + '\'' +
                ", pap='" + pap + '\'' +
                ", pl='" + pl + '\'' +
                ", pt='" + pt + '\'' +
                ", ro='" + ro + '\'' +
                ", ru='" + ru + '\'' +
                ", si='" + si + '\'' +
                ", sk='" + sk + '\'' +
                ", sl='" + sl + '\'' +
                ", sq='" + sq + '\'' +
                ", sr='" + sr + '\'' +
                ", su='" + su + '\'' +
                ", sv='" + sv + '\'' +
                ", sw='" + sw + '\'' +
                ", ta='" + ta + '\'' +
                ", te='" + te + '\'' +
                ", tg='" + tg + '\'' +
                ", th='" + th + '\'' +
                ", tl='" + tl + '\'' +
                ", tr='" + tr + '\'' +
                ", tt='" + tt + '\'' +
                ", udm='" + udm + '\'' +
                ", uk='" + uk + '\'' +
                ", ur='" + ur + '\'' +
                ", uz='" + uz + '\'' +
                ", vi='" + vi + '\'' +
                ", xh='" + xh + '\'' +
                ", yi='" + yi + '\'' +
                ", zh='" + zh + '\'';
    }
}
