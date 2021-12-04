﻿var Microsoft,__extends,WindowsFeedback,Feedback;(function(n){var t;(function(t){"use strict";function e(t){for(var f=null,r,i,u=0;u<t.length;u++){r=t[u];try{i=r.provide()}catch(e){n.le("Query provider "+r.name+" failed",e)}if(typeof i=="string"&&i.length>0){f=i;break}}return f}function p(t){var r=t.querySelectorAll('input[type="radio"][required][name]'),i=!0;return n.Core.ForEach(r,function(n){var r=n.getAttribute("name"),u='input[type="radio"][required][name="'+r+'"]:checked',f=t.querySelector(u)!==null;i=i&&f}),i}function l(t,i){var r,u;return t===window?t.document.documentElement["client"+i]:t.nodeType===9?(r=t.documentElement,u=t.body,Math.max(u["scroll"+i],u["offset"+i],r["scroll"+i],r["offset"+i],r["client"+i])):parseFloat(n.Core.GetComputedStyle(t)[i.toLowerCase()])}function a(n,t,i){var u={},f;for(var r in t)u[r]=n.style[r],n.style[r]=t[r];f=i(n);for(r in t)n.style[r]=u[r];return f}function w(){y(!1)}function v(n){y(!0,n)}function y(t,i){n.Core.ForEach(_d.querySelectorAll('input[type="text"], input[type="search"]'),function(n){n.hasAttribute("data-depends-on")||t&&n===i||(n.disabled=t)})}function i(n){var t=String(n);return t.length===1&&(t="0"+t),t}var f,r,o,s,h,c,u;t.selectedElementClass="hlsrc";t.menuListClass="hlselcxmnlist";t.menuButtonClass="hlselcxmnbt";t.verbatimTxtId="fbpgdgtx";window._w=window._w||window;window._d=window._d||_w.document;f=_d.documentElement.matches||_d.documentElement.webkitMatchesSelector||_d.documentElement.mozMatchesSelector||_d.documentElement.oMatchesSelector||_d.documentElement.msMatchesSelector;r=document.compatMode==="CSS1Compat";t.spokenQuery=null;n.Core.GenerateString=function(n){for(var i="",r="abcdefghijklmnopqrstuvwxyz0123456789",t=0;t<n;++t)i+=r.charAt(Math.floor(Math.random()*r.length));return i};n.Core.GenerateHtmlId=function(t){return"f"+n.Core.GenerateString(t-1)};n.Core.Stringify=function(t){var i="",u=0,r;switch(typeof t){case"object":if(t instanceof Array){for(i+="[",r=0;r<t.length;r++)r>0&&(i+=","),i+=n.Core.Stringify(t[r]);i+="]"}else if(t instanceof Boolean||t instanceof Date||t instanceof Number||t instanceof String)i=t.toString();else{i+="{";for(r in t)t.hasOwnProperty(r)&&(u>0&&(i+=","),i+='"'+r+'":'+n.Core.Stringify(t[r]),u++);i+="}"}return i;case"boolean":case"number":return t.toString();case"string":return'"'+t.replace(/[\\]/g,"\\\\").replace(/[\"]/g,'\\"').replace(/[\/]/g,"\\/").replace(/[\b]/g,"\\b").replace(/[\f]/g,"\\f").replace(/[\n]/g,"\\n").replace(/[\r]/g,"\\r").replace(/[\t]/g,"\\t")+'"';default:return null}};n.Core.FetchLocalStorage=function(){try{if(_w.localStorage){var n="CB47C15FA3044AB884F7E32B9FD32ED2";return _w.localStorage.setItem(n,"1"),_w.localStorage.removeItem(n),_w.localStorage}}catch(t){return undefined}};o=[{name:"page",provide:function(){var n=_ge("sb_form_q");return n&&n.value}},{name:"threshold",provide:function(){var t="ThresholdUtilities",n=_w[t]||_w.parent[t];return n&&n.getDecodedQuery&&n.getDecodedQuery()}},{name:"cortana",provide:function(){var t="SearchAppWrapper",i=_w[t]||_w.parent[t],r=i&&i.CortanaApp,n=r&&r.searchBox;return n&&n.getQueryText&&n.getQueryText().queryText}},{name:"spokenquery",provide:function(){return t.spokenQuery}},{name:"urlparam",provide:function(){if(typeof URL!="function")return null;var n=new URL(t.GetLocation()),i;return n&&n.search&&n.search.match&&(i=n.search.match(/[?&]q=([^?&#]*)/i))&&i.length>=2?decodeURI(i[1]):null}}];n.Core.GetUserQuery=function(){return e(o)};s=[{name:"locmet",provide:function(){var n="sj_locmet";return typeof _w[n]=="object"&&_w[n].GetCurrentUrl()}},{name:"miniSerp",provide:function(){var t=window.self!==window.top,n;return t?(n=_d.querySelector("base[href]"),n&&n.href):null}},{name:"location",provide:function(){return location.href}}];n.Core.GetLocation=function(){return e(s)};n.Core.GetISODate=function(n){return Date.prototype.toISOString?n.toISOString():n.getUTCFullYear()+"-"+i(n.getUTCMonth()+1)+"-"+i(n.getUTCDate())+"T"+i(n.getUTCHours())+":"+i(n.getUTCMinutes())+":"+i(n.getUTCSeconds())+"."+String((n.getUTCMilliseconds()/1e3).toFixed(3)).slice(2,5)+"Z"};n.Core.AddUrlParam=function(n,t,i){var r=n;return t&&t.length>0&&i&&(r=r+(r.indexOf("?")>=0?"&":"?")+t+"="+encodeURIComponent(i)),r};n.Core.IsEmptyObject=function(n){for(var t in n)return!1;return!0};h=/\s+$/;c=/^\s+/;n.Core.Trim=function(n){return n.trim?n.trim():n.replace(c,"").replace(h,"")};n.Core.IndexOf=function(n,t){var i;if(n.indexOf)i=n.indexOf(t);else{for(i=0;i<n.length;i++)if(n[i]===t)break;i=i<n.length?i:-1}return i};n.Core.EnableValidation=function(t,i){var r=function(t){var r=sj_et(t),u;r&&(!!i==!1&&v(r),u=n.Core.GetTextInputValue(r),u&&u.length!==0||(Lib.CssClass.add(r,"active"),r.value=""))},u=function(n){var t=sj_et(n),i;t&&(w(),Lib.CssClass.remove(t,"error"),i=_w.feedback&&_w.feedback.config&&_w.feedback.config.dialog&&_w.feedback.config.dialog.emulatePlaceholderText,t.value.length===0&&i&&(Lib.CssClass.remove(t,"active"),t.value=t.getAttribute("data-txt")))},f=function(n){var t=sj_et(n);t&&v(t)};n.Core.ForEach(t.querySelectorAll('textarea, input[type="text"]'),function(n){sj_be(n,"blur",u);sj_be(n,"change",u);i?(sj_be(n,"focus",f),sj_be(n,"keydown",r),sj_be(n,"tap",r),sj_be(n,"taphold",r),sj_be(n,"mouseup",r),sj_be(n,"click",r)):sj_be(n,"focus",r)})};n.Core.ValidateInputs=function(i){var f=i.querySelectorAll('input[type="text"][data-err], textarea[data-err]'),r=!0,u=null;return n.Core.ForEach(f,function(f){var e=f,o=e.getAttribute("data-depends-on"),s=typeof o=="string"&&o.length>0&&_ge(o),h=e.value;if(s&&!s.checked||!s&&e.getAttribute("data-optional")){Lib.CssClass.remove(e,"error");return}e.id===n.Core.verbatimTxtId&&n.CheckboxMenus&&n.CheckboxMenus.IsAtLeastOneItemChecked()||((t.GetTextInputValue(e).length===0||n.Core.Trim(h)==="")&&(Lib.CssClass.add(e,"error"),u||(u=e,u.focus()),r=!1),r=r&&p(i))}),r};n.Core.GetTextInputValue=function(n){if(!n)return"";var t=n.value;return(t===n.getAttribute("data-txt")||t===n.getAttribute("data-err"))&&(t=""),t};n.Core.LoopFocus=function(n){var e,i,o,h,s,r,l;if(n){var u=null,f=null,c=n.querySelectorAll("*");for(e=0;e<c.length;e++)if(i=c[e],o=!1,i instanceof HTMLInputElement||i instanceof HTMLSelectElement||i instanceof HTMLTextAreaElement||i instanceof HTMLButtonElement?(h=i,o=!h.disabled&&!h.readOnly):i instanceof HTMLAnchorElement&&(o=!!i.href),o&&!t.IsHidden(i)){for(s=i,r=s;r!==n&&!t.IsHidden(r);)r=r.parentNode;l=r!==n;l||(u===null&&(u=s),f=s)}u&&f&&(sj_be(u,"keydown",function(n){n.key!=="Tab"||!n.shiftKey||n.ctrlKey||n.altKey||(n.preventDefault(),f.focus())}),sj_be(f,"keydown",function(n){n.key!=="Tab"||n.shiftKey||n.ctrlKey||n.altKey||(n.preventDefault(),u.focus())}))}};n.Core.ForEach=function(n,t){for(var r,u,i=0;i<n.length;i++)if(r=n[i],u=t(r),u===!1)break};n.Core.WindowScrollTop=function(){return _w.pageYOffset||r&&_d.documentElement.scrollTop||_d.body.scrollTop};n.Core.WindowScrollLeft=function(){return _w.pageXOffset||r&&_d.documentElement.scrollLeft||_d.body.scrollLeft};n.Core.Width=function(n){return l(n,"Width")};n.Core.Height=function(n){return l(n,"Height")};n.Core.Remove=function(n){n&&n.parentNode&&n.parentNode.removeChild&&n.parentNode.removeChild(n)};n.Core.ForEachChildren=function(n,t){for(var i=n.firstChild;i;i=i.nextSibling)i.nodeType===1&&t(i)};n.Core.Matches=function(n,t){return f.call(n,t)};n.Core.Offset=function(t){var i,r,u,f;if(t)return t.getClientRects().length?(i=t.getBoundingClientRect(),r=i.height!==undefined?i.height||i.width:i.bottom-i.top||i.right-i.left,!r)?i:(u=_d.documentElement.clientTop||_d.body.clientTop||0,f=_d.documentElement.clientLeft||_d.body.clientLeft||0,{top:i.top+n.Core.WindowScrollTop()-u,left:i.left+n.Core.WindowScrollLeft()-f}):{top:0,left:0}};u={position:"absolute",visibility:"hidden",display:"block"};n.Core.GetComputedStyle=function(n){return!n||!n.style?undefined:_w.getComputedStyle?_w.getComputedStyle(n):n.currentStyle};n.Core.ApplyCss=function(n,t){if(n&&n.style&&typeof t=="object")for(var i in t)n.style[i]=t[i]};n.Core.OuterWidth=function(t){return!t||!t.style?undefined:n.Core.IsHidden(t)?a(t,u,function(n){return n.offsetWidth}):t.offsetWidth};n.Core.OuterHeight=function(t){return!t||!t.style?undefined:n.Core.IsHidden(t)?a(t,u,function(n){return n.offsetHeight}):t.offsetHeight};n.Core.Show=function(n,t){n&&n.style&&t!==undefined&&t!==null&&(n.style.display=t)};n.Core.Hide=function(n){n&&n.style&&(n.style.display="none")};n.Core.IsHidden=function(t){return!t||!t.style?undefined:n.Core.GetComputedStyle(t).display==="none"};n.Core.SetPosition=function(n,i,r,u){var f=i,e=r;i&&r&&(u&&u.length===2&&(u[0]==="b"&&(f-=t.OuterHeight(n)),u[1]==="r"&&(e-=t.OuterWidth(n))),t.ApplyCss(n,{top:f+"px",left:e+"px"}))};n.Core.GetElementByHlid=function(n,t){return _d.querySelector('[hlid="'+n+'"]'+(t?"."+t:""))||undefined};n.Core.GetAllElementsByHlid=function(n){return _d.querySelectorAll('[hlid="'+n+'"]')};n.Core.GetHlid=function(n){return n&&(n.getAttribute("hlid")||undefined)};n.Core.SetHlid=function(n,t){n&&n.setAttribute("hlid",t)};n.Core.GetSelectedElements=function(){return _d.querySelectorAll("."+n.Core.selectedElementClass)};n.le=function(n,t){SharedLogHelper&&SharedLogHelper.LogError&&SharedLogHelper.LogError("Feedback: "+n,null,t)};n.leh=function(t,i,r){n.le("Feedback: "+t+" handler failed in "+i,r)};n.fel=function(t,i){for(var u=[],r=2;r<arguments.length;r++)u[r-2]=arguments[r];try{u.unshift(t);sj_evt.fire.apply(null,u)}catch(f){n.leh(t,i,f);throw f;}}})(t=n.Core||(n.Core={}))})(Feedback||(Feedback={})),function(){"use strict";var n=function(){function n(){this.maxSizeBytes=35e5;this.feedbackUploadUrl="/feedback/submission";this.maxSendTries=3;this.requestTimeout=1e4}return n.prototype.Send=function(n,t,i,r){t===void 0&&(t=undefined);i===void 0&&(i=undefined);r===void 0&&(r=undefined);var u=typeof t=="undefined"?Feedback.Core.GenerateString(32):t;return this.SendAttempt(n,u,1,i,r)},n.prototype.SendAttempt=function(n,t,i,r,u){var f=sj_gx(),e=Feedback.Core.AddUrlParam(this.feedbackUploadUrl,"debugid",t);_w.feedback&&_w.feedback.config&&_w.feedback.config.postIgFlightEnabled&&(e=Feedback.Core.AddUrlParam(e,"IG",_G.IG));f.open("POST",e,!0);f.timeout=this.requestTimeout;f.setRequestHeader("Content-Type","application/json; charset=UTF-8");f.onreadystatechange=function(){f.readyState==f.DONE&&(f.status==204||f.status==1223?this.OnSendSuccess(n,t,r):i>=this.maxSendTries?this.OnOnlineSendFailure(n,t,r):(typeof _G!="undefined"&&_G.IG?Log2.LogEvent("ClientInst",{error:"Will need to retry sending the payload because not all of them reached the live bing.com servers"},"Feedback.Error",null,null,_G.IG,null,null):Log2.LogEvent("ClientInst",{error:"_G.IG was not available when we wanted to log that we will resend the payload"},"Feedback.Error",null,null,null,null,null),this.SendAttempt(n,t,++i,r,u)))}.bind(this);f.send(JSON.stringify(n))},n.prototype.OnSendSuccess=function(n,t,i){i===void 0&&(i=undefined);delete n.html;typeof _G!="undefined"&&_G.IG?Log2.LogEvent("ClientInst",JSON.stringify(n),"Feedback.Online",null,null,_G.IG,null,null):Log2.LogEvent("ClientInst",{error:"_G.IG was not available when submitting feedback online"},"Feedback.Error",null,null,null,null,null);typeof i!="undefined"&&i(t)},n.prototype.OnOnlineSendFailure=function(n,t,i){i===void 0&&(i=undefined);delete n.html;typeof _G!="undefined"&&_G.IG?Log2.LogEvent("ClientInst",JSON.stringify(n),"Feedback.Offline",null,null,_G.IG,null,null):Log2.LogEvent("ClientInst",{error:"_G.IG was not available when submitting feedback offline"},"Feedback.Error",null,null,null,null,null);typeof i!="undefined"&&i(t)},n}();_w.WindowsFeedbackProtocol=new n}(WindowsFeedback||(WindowsFeedback={})),function(n){var t;(function(n){"use strict";var t=function(){function n(n){this.base64ImageBlobs=this.GetImageBlobsAsBase64(n)}return n.prototype.Manipulate=function(n){if(n instanceof HTMLImageElement){var t=n;t.src&&this.base64ImageBlobs[t.src]&&(t.src=this.base64ImageBlobs[t.src])}},n.prototype.GetImageBlobsAsBase64=function(n){for(var u=n.querySelectorAll("img[src^='blob:']"),f={},t,i,e,o,r=0;r<u.length;r++)t=u[r],i=document.createElement("canvas"),i.width=t.width,i.height=t.height,e=i.getContext("2d"),e.drawImage(t,0,0),o=i.toDataURL(),f[t.src]=o;return f},n}();n.InlineImagesManipulator=t})(t=n.Search||(n.Search={}))}(Microsoft||(Microsoft={})),function(n){var t;(function(n){"use strict";var t=function(){function n(n){this.DocumentFragment=document.createDocumentFragment();this.DocumentFragment.appendChild(n.cloneNode(!0))}return n.prototype.ManipulateElementsBySelector=function(n,t){var u,i,e,f,r,o;if(t)for(u=this.DocumentFragment.querySelectorAll(n),i=0,e=u.length;i<e;i++)for(f=u[i],r=0;r<t.length;r++)o=t[r],typeof f!="undefined"&&o.Manipulate(f)},n.prototype.DeleteElementsBySelector=function(n){for(var t;t=this.DocumentFragment.querySelector(n);)t&&t.parentNode.removeChild(t)},n.prototype.SerializeToHtml=function(){return this.DocumentFragment.firstChild.outerHTML},n}();n.DOMCopyManipulator=t})(t=n.Search||(n.Search={}))}(Microsoft||(Microsoft={})),function(n){"use strict";var t=function(){function n(n,t){this.fileName=n;this.contentType=t}return n}();n.FeedbackFile=t}(Feedback||(Feedback={})),function(n){"use strict";var t=function(){function t(){var n=_w.feedback;this.timeout=n&&n.config&&n.config.getFilesTimeout;this.recreateFilePromisesMap();this.sscfg=n.screenshot;sj_be(_w,"message",this.windowEventListener.bind(this))}return t.isImage=function(n){return n==="image/png"||n==="image/jpeg"},t.prototype.getFiles=function(n,t,i){var s=[],e=this.filePromises,h=!!_w.Promise,o=0,u,f,r,c;for(u in e)if(e.hasOwnProperty(u)&&(n||!t(u)))for(f=e[u],r=0;r<f.length;r++)c=h?this.waitForFile(f[r],this.timeout).then(function(n){if(n&&n.base64Content&&n.contentType&&n.fileName)if(n.base64Content.length===0)i("Did not populate base64Content before submitting for "+n.fileName);else return n;else o++;return null},function(){return null}):f[r],s.push(c);return h?new _w.Promise(function(n){_w.Promise.all(s).then(function(t){o>0&&i(o+" feedback files not returned in time for feedback submit.");n(t.filter(function(n){return!!n}))},function(){})}):{then:function(n){n&&n([])}}},t.prototype.collect=function(n){var t,i;this.recreateFilePromisesMap();this.filesRequested=!0;try{t=_w.SearchAppWrapper&&SearchAppWrapper.CortanaApp;t&&t.getFeedbackFilesAsync?(i=this,t.getFeedbackFilesAsync().then(function(t){if(t)for(var r=0;r<t.length;r++)i.collectFile(t[r],n);i.fileDescriptorsReceived=!0},function(t){n("GetFeedbackFiles","FeedbackFileFetchAllError","Could not get feedback files: "+t.message);i.fileDescriptorsReceived=!0})):this.fileDescriptorsReceived=!0}catch(r){n("GetFeedbackFiles","FeedbackFileFetchAllError","Could not get feedback files")}},t.prototype.clear=function(){this.recreateFilePromisesMap();this.deleteScreenshotIframe()},t.prototype.takeScreenshot=function(){if(this.sscfg&&_w.Promise){this.createScreenshotIframe();var n=_w.frames[t.ssFrameId];n&&this.waitForIFrameAndFiles(n)}},t.prototype.collectFile=function(t,i){try{var r=this,u=t.getBase64ContentAsync().then(function(i){if(!i)return null;var u=new n.FeedbackFile(t.fileName,t.contentType);return u.base64Content=i,t.fileName==="CortanaTrace.log"&&_w.atob&&r.extractSpokenQuery(i),u},function(){return null});this.addPromise(t.contentType,u)}catch(f){i("GetFeedbackFile","FeedbackFileFetchSingleError","GetFeedbackFile: Could not get feedback file content")}},t.prototype.waitForFile=function(n,t){return new _w.Promise(function(i){sb_st(function(){i(null)},t);n.then(function(n){i(n)},function(){i(null)})})},t.prototype.recreateFilePromisesMap=function(){this.filePromises={};this.fileDescriptorsReceived=!1;this.filesRequested=!1},t.prototype.waitForIFrameAndFiles=function(n){if((!this.filesRequested||!this.fileDescriptorsReceived||!this.isWaitingForContentType(t.isImage))&&n.contentWindow){if(!n.contentWindow.screenshot||this.filesRequested&&!this.fileDescriptorsReceived){var i=this;sb_st(function(){i.waitForIFrameAndFiles(n)},100);return}n.contentWindow.postMessage({name:"feedback",event:"screenshotRequested"},_w.location.origin)}},t.prototype.windowEventListener=function(t){var i,r;t.origin===_w.location.origin&&t.data&&t.data.name==="feedback"&&(i=t.data,i.event==="screenshotError"?n.le(i.message,i.error):i.event==="screenshotReady"&&i.file&&(this.addPromise(i.file.contentType,_w.Promise.resolve(i.file)),this.sscfg.show&&(r=sj_ce("img","fdbkimg"),_w.top.document.body.appendChild(r),r.src="data:image/jpeg;base64,"+i.file.base64Content,r.style.position="fixed",r.style.top="0",r.style.left="0",r.style["z-index"]="1000009",sj_be(r,"mousedown",function(){r.style.opacity="0.1"}),sj_be(r,"mouseup",function(){r.style.opacity="1"}))))},t.prototype.addPromise=function(n,t){this.filePromises[n]=this.filePromises[n]||[];this.filePromises[n].push(t)},t.prototype.isWaitingForContentType=function(n){var t=this.filePromises;for(var i in t)if(t.hasOwnProperty(i)&&n(i))return!0;return!1},t.prototype.extractSpokenQuery=function(t){for(var u=decodeURIComponent(escape(_w.atob(t))),f=/UserSaid='(.*?)'. Dialog={/g,r,i=null;r=f.exec(u);)i=r[1];typeof i=="string"&&i.length>0&&(n.Core.spokenQuery=i)},t.prototype.createScreenshotIframe=function(){var u=document.createElement("script"),r,i,n;u.innerHTML="{ var feedback = { screenshot: { backgroundColor: "+(this.sscfg.backgroundColor?'"'+this.sscfg.backgroundColor+'"':null)+", log: "+this.sscfg.log+", proxy: "+(this.sscfg.proxy?'"'+this.sscfg.proxy+'"':null)+' } }; window["feedback"] = feedback; }';r=document.createElement("script");r.src=this.sscfg.resourceUrl;i=document.createElement("iframe");i.id=t.ssFrameId;i.className="hlig";document.body.appendChild(i);n=i.contentWindow.document;n.open();n.write("<body>");n.write(u.outerHTML);n.write(r.outerHTML);n.write("<\/body>");n.close()},t.prototype.deleteScreenshotIframe=function(){var n=_w.frames[t.ssFrameId];n&&n.parentElement.removeChild(n)},t.ssFrameId="feedback-screenshot",t}();n.FeedbackFiles=t;n.files=new t}(Feedback||(Feedback={})),function(n){var t;(function(){"use strict";function u(t,i){var u=t.getAttribute("id"),f;u||(u="genId"+n.length,t.setAttribute("id",u));f=new r(u,i,t.getAttribute(i));n.push(f)}function i(n,t,i){i===null?n.removeAttribute(t):n.setAttribute(t,i)}function t(n,t,r,f){for(var e,s=_d.querySelectorAll(r),o=0;o<s.length;o++)(e=s[o],f&&e.id&&f[e.id])||(u(e,n),i(e,n,t))}function f(n){for(var u=_d.querySelectorAll(n),e=1,f={},t,i,r=0;r<u.length;++r){if(t=u[r],!t.id){for(;;)if(i="fbpgdgelem"+e++,!_ge(i))break;t.id=i}f[t.id]=t}return f}function e(){var i="tabindex",r="-1",n=f("#fbpgdg, #fbpgdg *");t(i,r,"div",n);t(i,r,"svg",n);t(i,r,"a",n);t(i,r,"li",n);t(i,r,"input",n);t(i,r,"select",n);t("aria-hidden","true","body :not(script):not(style)",n)}function o(){for(var r,t=0;t<n.length;t++)r=_d.getElementById(n[t].id),r&&i(r,n[t].attributeName,n[t].originalAttributeValue);n.length=0}function s(){typeof sj_evt!="undefined"&&(sj_evt.bind("onFeedbackStarting",function(){e()}),sj_evt.bind("onFeedbackClosing",function(){o()}))}var n=[],r=function(){function n(n,t,i){this.id=n;this.attributeName=t;this.originalAttributeValue=i}return n}();s()})(t=n.Accessibility||(n.Accessibility={}))}(Feedback||(Feedback={})),function(n){"use strict";var t=function(){function t(){this.callbacks=[];this.debugValues={}}return t.prototype.setContextValue=function(n,t){typeof n!="string"||n.length<1||(this.debugValues[n]=t)},t.prototype.setContextValues=function(n){if(n)for(var t in n)n.hasOwnProperty(t)&&this.setContextValue(t,n[t])},t.prototype.registerCollectionCallback=function(n){n&&this.callbacks.push(n)},t.prototype.collect=function(t){for(var f=this.getStaticValues(),e,r,u,i=0;i<this.callbacks.length;i++){e=this.callbacks[i];try{r=e(t)}catch(o){n.leh("debug collector callback","c",o);throw o;}for(u in r)r.hasOwnProperty(u)&&(f[u]=r[u])}return f},t.prototype.clear=function(){for(var n in this.debugValues)delete this.debugValues[n];this.callbacks=[]},t.prototype.getStaticValues=function(){var t={};for(var n in this.debugValues)this.debugValues.hasOwnProperty(n)&&(t[n]=this.debugValues[n]);return t},t}();n.debugCollector=new t}(Feedback||(Feedback={})),function(n){"use strict";var t=function(){function n(){var n=_w.feedback;this.feedbackContainerId="fbpgdg";this.screenshotChkName="screenshotAllowed";this.sendmailChkName="sendmail";this.aliasTxtName="alias";this.privacyPolicyUrl="http://go.microsoft.com/fwlink/?LinkId=521839";this.learnMoreLinkUrl="http://go.microsoft.com/fwlink/?LinkID=618051";this.reportPrivacyPolicyUrl="https://www.microsoft.com/concern/bing";this.internalCheckUrl="/feedback/internal";this.internalCheckRequestTimeout=2e3;this.dlAlias="sfeed";this.dlLink="mailto:"+this.dlAlias;this.localStorage=Feedback.Core.FetchLocalStorage();this.selectedByDefaultCatIdx=0;this.fbcfg=n.config;this.sscfg=n.screenshot}return n.prototype.ResetShowForm=function(){},n.prototype.CreateShowForm=function(){},n.prototype.AddInternalFormElements=function(){},n.prototype.HideForm=function(){},n.prototype.RemoveForm=function(){},n.LogError=function(n,t,i){Log2.LogEvent("ClientInst",{source:n,type:t,error:i},"Feedback.Error",null,null,_G.IG,null,null)},n.prototype.Show=function(t,i){var e,h;if(t===void 0&&(t=null),i===void 0&&(i=!1),e=!!this.fbcfg.capturePage,SearchAppWrapper!=null&&SearchAppWrapper.CortanaApp!=null&&SearchAppWrapper.CortanaApp.themeColors&&SearchAppWrapper.CortanaApp.themeColors.accent!=this.lastAccentColor){this.lastAccentColor=SearchAppWrapper.CortanaApp.themeColors.accent;var o=!1,s="feedback-accent-style",r=_ge(s);r||(r=_d.createElement("style"),r.setAttribute("id",s),r.type="text/css",o=!0);var c=SearchAppWrapper.CortanaApp.themeColors,u="",f="#"+c.accentDark1.substr(3);u="#fbpgdg a { color: "+f+"}";u+="#fbpgdg :first-child.button a, #fbpgdg :first-child.button input {background-color: "+f+"; border-color: "+f+"}";r.innerHTML=u;o&&_d.head.appendChild(r)}typeof _G!="undefined"&&_G.IG?Log2.LogEvent("ClientInst",null,"FeedbackStarted",null,null,_G.IG,null,null):Log2.LogEvent("ClientInst",{type:"ImpressionSubmitError",error:"_G.IG was not available when showing form"},"Feedback.Error",null,null,null,null,null);sj_evt.fire("onFeedbackStarting",i);h=_ge(this.feedbackContainerId);h===null?this.CreateShowForm(t):this.ResetShowForm();Feedback.CortanaState.SetForFeedback();_ge("fbpgdgtp1").focus();sj_evt.fire("ajax.feedback.initialized",Feedback);Feedback.files.collect(n.LogError);e&&this.sscfg&&Feedback.files.takeScreenshot()},n.prototype.Hide=function(){var n=_ge(this.feedbackContainerId);n&&(sj_evt.fire("onFeedbackClosing"),this.HideForm());this.FeedbackFormCleanup()},n.prototype.Remove=function(){var n=_ge(this.feedbackContainerId);n&&(sj_evt.fire("onFeedbackClosing"),this.RemoveForm());this.FeedbackFormCleanup()},n.prototype.FeedbackFormCleanup=function(){var n=_ge("fbpgdgsbbt");n&&Lib.CssClass.remove(n.parentElement,"inactive");Feedback.CortanaState.Reset();Feedback.files.clear()},n.prototype.CheckInternal=function(n){var t=sj_gx(),i=this.internalCheckUrl,r;this.fbcfg.postIgFlightEnabled&&(i=Feedback.Core.AddUrlParam(i,"IG",_G.IG));r=this;t.open("HEAD",i,!0);t.timeout=this.internalCheckRequestTimeout;t.onreadystatechange=function(){t.readyState===t.DONE&&t.status===204&&r.AddInternalFormElements(n)}.bind(this);t.send()},n.prototype.AddLabeledInput=function(n,t,i,r,u,f,e,o,s,h,c){var v,l,a;return r===void 0&&(r=undefined),u===void 0&&(u=undefined),f===void 0&&(f=undefined),e===void 0&&(e="inputwrapper"),o===void 0&&(o=null),s===void 0&&(s=null),h===void 0&&(h=null),v=sj_ce("div",null,e),l=sj_ce("input",h,o),l.type=t,u===!0&&(l.checked=!0),typeof r=="string"&&(l.name=r),typeof f=="string"&&(l.value=f),typeof c=="string"&&l.setAttribute("aria-label",c),a=sj_ce("label",null,s),a.appendChild(l),a.appendChild(_d.createTextNode(i)),v.appendChild(a),n.appendChild(v),l},n.prototype.AddLink=function(n,t,i,r){var u=sj_ce("a",t);return u.href=i,u.target="_blank",u.innerText=r,n.appendChild(u),u},n.prototype.AddTextArea=function(n,t,i,r){r===void 0&&(r=!0);var u=sj_ce("textarea",t);return u.placeholder=i,u.required=!0,n.appendChild(u),u},n.prototype.AddText=function(n,t,i,r){var u=sj_ce(t);return u.innerText=i,typeof r!="undefined"&&(u.className=r),n.appendChild(u),u},n.prototype.AddButton=function(n,t,i){var r=sj_ce("input");return r.type=t,r.value=i,n.appendChild(r),r},n.prototype.OnSubmitForm=function(t){var f,e,h,c,l,a,p,w;if(t.preventDefault(),Feedback.Core.ValidateInputs(_ge(this.feedbackContainerId))!==!1){Lib.CssClass.add(_ge("fbpgdgsbbt").parentElement,"inactive");var b=!!this.fbcfg.capturePage,o=this.GetFormValue(this.screenshotChkName,"checked"),s=b&&(!this.FormElementExists(this.screenshotChkName)||o),u=Feedback.debugCollector.collect(s),i={partner:"BingLegacy",feedbackType:"feedback",feedbackPackage:"bing.feedback.qf",url:location.href,width:Math.round(_w.innerWidth),height:Math.round(_w.innerHeight),source:typeof u.source=="undefined"?"windows":u.source,send_mail:!0};o!==null&&(i.screenshotAllowed=o);f=this.GetFormValue(this.sendmailChkName,"checked");f!==null&&(i.send_mail=f);e=this.GetFormValue(this.aliasTxtName,"value");e&&(!f||(i.alias=e),this.SetAlias(e));typeof _G!="undefined"&&(_G.IG&&(i.impression_guid=_G.IG),_G.EventID&&(i.traceId=_G.EventID),_G.ST&&(i.timeStamp=Feedback.Core.GetISODate(_G.ST)),_G.V?i.vertical=_G.V:_G.P&&(i.vertical=_G.P),_G.PN!==undefined&&(i.canvas=_G.PN));var v=window.frames.miniIframeSerp,y=v&&v.contentWindow,r=y&&y._G;r&&(r.IG||r.EventID)&&(h=i.structured_data=i.structured_data||{},r.IG&&(h.impression_guid_miniSerp=r.IG),r.EventID&&(h.traceId_miniSerp=r.EventID));c=Feedback.Core.GetUserQuery();c!==null&&(i.query=c);for(l in u)i[l]=u[l];i.canvas!==undefined&&(i.vertical=i.canvas);a=this.GetFormValue(Feedback.Core.verbatimTxtId,"value");typeof a=="string"&&(i.text=a);i.type=this.DetermineFeedbackType();p=function(t){n.LogError("OnSubmitForm","FeedbackFileTimeoutError",t)};w=this;Feedback.files.getFiles(s,function(){return!0},p).then(function(n){w.ContinueSubmit(i,s,n)},function(t){n.LogError("OnSubmitForm","FeedbackFileGetError",t.toString())})}},n.prototype.ContinueSubmit=function(n,t,i){if(t){var r=new Microsoft.Search.DOMCopyManipulator(_d.documentElement);r.DeleteElementsBySelector("script");r.DeleteElementsBySelector("#aRmsDefer");r.ManipulateElementsBySelector("img",[new Microsoft.Search.InlineImagesManipulator(r.DocumentFragment)]);n.html=r.SerializeToHtml()}i.length>0&&(n.feedbackFiles=i);_w.WindowsFeedbackProtocol&&WindowsFeedbackProtocol.Send(n);this.Hide();typeof _G!="undefined"&&_G.IG?Log2.LogEvent("ClientInst",{target:"Submit"},"Feedback.Click",null,null,_G.IG,null,null):Log2.LogEvent("ClientInst",{type:"ImpressionSubmitError",error:"_G.IG was not available when clicking on Submit button"},"Feedback.Error",null,null,null,null,null)},n.prototype.OnCloseForm=function(n){n.preventDefault();this.Hide();typeof _G!="undefined"&&_G.IG?Log2.LogEvent("ClientInst",{target:"Cancel"},"Feedback.Click",null,null,_G.IG,null,null):Log2.LogEvent("ClientInst",{type:"ImpressionCloseError",error:"_G.IG was not available when clicking on Cancel button"},"Feedback.Error",null,null,null,null,null)},n.prototype.GetCategoryRadioButtons=function(n){return n.querySelectorAll('input[name="type"]')},n.prototype.DetermineFeedbackType=function(){for(var r=_ge(this.feedbackContainerId),t=this.GetCategoryRadioButtons(r),i=1,n=0,u=t.length;n<u;n++)if(t[n].checked){i=+t[n].value;break}return i},n.prototype.GetFormValue=function(n,t){var r=_ge(this.feedbackContainerId),i=r.querySelector('[id="'+n+'"], [name="'+n+'"]');return i&&(!i.placeholder||i.placeholder!==i[t])?i[t]:null},n.prototype.FormElementExists=function(n){var t=_ge(this.feedbackContainerId),i=t.querySelector('input[name="'+n+'"]');return i?!0:!1},n.prototype.GetLocString=function(n){return LocStringManager.getLocString({uiCulture:SearchAppWrapper.CortanaApp.uiLanguage,name:"LocStrings",namespace:"Feedback"})[n]},n.prototype.GetAlias=function(){return this.localStorage?this.localStorage.getItem(this.aliasTxtName):null},n.prototype.SetAlias=function(n){this.localStorage&&this.localStorage.setItem(this.aliasTxtName,n)},n}();n.WindowsFeedbackFormBase=t;typeof sj_evt!="undefined"&&(sj_evt.bind("WindowsFeedback.Form.Show",function(){_w.WindowsFeedbackForm.Show()},1),sj_evt.bind("WindowsFeedback.Form.Hide",function(){_w.WindowsFeedbackForm.Hide()}));typeof SearchAppWrapper!="undefined"&&SearchAppWrapper.CortanaApp&&SearchAppWrapper.CortanaApp.addEventListener&&SearchAppWrapper.CortanaApp.addEventListener("feedbackformrequested",function(n){typeof n!="undefined"&&n!==null&&(n.isHandled=!0);_w.WindowsFeedbackForm.Show(null,!0)})}(WindowsFeedback||(WindowsFeedback={}));__extends=this&&this.__extends||function(){var n=function(t,i){return n=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(n,t){n.__proto__=t}||function(n,t){for(var i in t)t.hasOwnProperty(i)&&(n[i]=t[i])},n(t,i)};return function(t,i){function r(){this.constructor=t}n(t,i);t.prototype=i===null?Object.create(i):(r.prototype=i.prototype,new r)}}(),function(n){"use strict";var t=function(n){function t(){var t=n.call(this)||this;return t.modalShieldId="feedbackModalShield",t}return __extends(t,n),t.prototype.CreateShowForm=function(n){var ut=sj_ce("div",this.modalShieldId,"modalShield hlig"),r=sj_ce("div",this.feedbackContainerId,"modal hlig"),t=sj_ce("div",null,null),s=sj_ce("div","fbpgdghd","hlig"),g,h,i,c,u,l,nt,a,v,y,p,o,w,tt,b,f,d,e,rt;t.appendChild(s);s.appendChild(sj_ce("div",null,"padding hlig"));g=this.AddText(s,"h2",this.GetLocString("WINDOWS_TITLE_TEXT"),"step1 hlig");h=sj_ce("div","fbctgrs");t.appendChild(h);i=sj_ce("div",null,"hlig step1 fbctgcntsdk");i.setAttribute("role","radiogroup");i.setAttribute("aria-label",this.GetLocString("DIALOG_COMMENT_TYPE_LABEL"));var ft=this.AddLabeledInputSdk(i,"radio",this.GetLocString("DIALOG_COMMENT_TYPE4"),"type",this.selectedByDefaultCatIdx==0,"1","inline hlig fbctgctlsdk","hlig","hlig","fbpgdgtp1"),et=this.AddLabeledInputSdk(i,"radio",this.GetLocString("DIALOG_COMMENT_TYPE5"),"type",this.selectedByDefaultCatIdx==1,"2","inline hlig fbctgctlsdk","hlig","hlig","fbpgdgtp2"),ot=this.AddLabeledInputSdk(i,"radio",this.GetLocString("DIALOG_COMMENT_TYPE6"),"type",this.selectedByDefaultCatIdx==2,"3","inline hlig fbctgctlsdk","hlig","hlig","fbpgdgtp3");h.appendChild(i);c=sj_ce("div","fbvrbtm","hlig");t.appendChild(c);u=this.AddTextArea(c,Feedback.Core.verbatimTxtId,this.GetLocString("WINDOWS_DIALOG_COMMENT_TEXT"));u.setAttribute("maxlength","1200");u.className="step1 hlig";u.setAttribute("aria-label",this.GetLocString("DIALOG_COMMENT_LABEL"));u.setAttribute("data-err",this.GetLocString("DIALOG_COMMENT_ERROR_TEXT"));l=sj_ce("div","fbpgdgpnl","step1");t.appendChild(l);nt=this.AddLabeledInputSdk(l,"checkbox",this.GetLocString("DIALOG_INCLUDE_SCREENSHOT"),this.screenshotChkName,!0,undefined,"hlig fb-t-small fb-mrg-med","hlig","hlig","fbpgdgsschk");a=sj_ce("div","fbml");t.appendChild(a);this.CheckInternal(a);v=sj_ce("div","fbpgdgpnlrp");t.appendChild(v);y=sj_ce("p");v.appendChild(y);this.AddLink(y,"fbpgdgpslk",this.reportPrivacyPolicyUrl,this.GetLocString("REPORT_LEGAL_OR_PRIVACY_CONCERN"));p=sj_ce("div","fbpgdgpnl2","step1");t.appendChild(p);o=sj_ce("div");p.appendChild(o);w=sj_ce("p");o.appendChild(w);tt=this.AddLink(w,"fbpgdgpslk",this.privacyPolicyUrl,this.GetLocString("PRIVACY_STATEMENT_LINK_TEXT"));b=sj_ce("p");o.appendChild(b);var st=this.AddLink(b,"fbpgdgplmlk",this.learnMoreLinkUrl,this.GetLocString("LEARN_MORE_LINK_TEXT")),k=sj_ce("div",null,"container"),it=sj_ce("div",null,"button step1 hlig");return k.appendChild(it),f=sj_ce("input","fbpgdgsbbt","hlig"),f.type="submit",f.value=this.GetLocString("DIALOG_SEND_BUTTON_TEXT"),it.appendChild(f),d=sj_ce("div",null,"button step1 hlig"),k.appendChild(d),e=sj_ce("input","fbpgdgcnclbt","hlig"),e.type="button",e.value=this.GetLocString("DIALOG_CANCEL_BUTTON_TEXT"),d.appendChild(e),t.appendChild(k),sj_be(e,"click",this.OnCloseForm.bind(this)),sj_be(f,"click",this.OnSubmitForm.bind(this)),r.appendChild(t),Feedback.Core.EnableValidation(r,!1),Feedback.Core.LoopFocus(r),_d.body.appendChild(ut),rt=_ge(n)||_d.body,rt.appendChild(r),typeof TestHooksEnabled!="undefined"&&TestHooksEnabled===!0&&(r.setAttribute("data-tag","WindowsFeedback.Form"),g.setAttribute("data-tag","WindowsFeedback.FormTitle"),ft.setAttribute("data-tag","WindowsFeedback.SuggestRadioButton"),et.setAttribute("data-tag","WindowsFeedback.LikeRadioButton"),ot.setAttribute("data-tag","WindowsFeedback.DislikeRadioButton"),u.setAttribute("data-tag","WindowsFeedback.VerbatimTextArea"),nt.setAttribute("data-tag","WindowsFeedback.IncludeScreenshotCheckbox"),tt.setAttribute("data-tag","WindowsFeedback.PrivacyLink"),st.setAttribute("data-tag","WindowsFeedback.LearnMoreLink"),f.setAttribute("data-tag","WindowsFeedback.SubmitButton"),e.setAttribute("data-tag","WindowsFeedback.CloseButton")),r},t.prototype.AddInternalFormElements=function(n){var s=this.GetAlias(),h="fbpgdgml",u=sj_ce("div",null,"hlig step1 internal fb-t-small"),i,r,e,c,f,l,o,t;this.AddText(u,"h3",this.GetLocString("DIALOG_MSFT_INTERNAL"));n.appendChild(u);i=sj_ce("div",null,"hlig fb-mrg-med");r=sj_ce("input",h,"hlig");r.type="checkbox";r.name=this.sendmailChkName;r.checked=!0;i.appendChild(r);e=sj_ce("label",null,"hlig");e.htmlFor=h;c=this.GetLocString("DIALOG_SEND_EMAIL_LABEL").replace("{0}","Bing");e.appendChild(_d.createTextNode(c));i.appendChild(e);f=sj_ce("span");f.dir="ltr";f.innerHTML+="&nbsp;(";l=this.AddLink(f,null,this.dlLink,this.dlAlias);l.className="hlig";f.innerHTML+=")";i.appendChild(f);o=sj_ce("label",null,"hlig");o.htmlFor="fbpgdgal";o.appendChild(_d.createTextNode(this.GetLocString("DIALOG_ALIAS_LABEL")));i.appendChild(o);i.appendChild(sj_ce("br",null,"hlig"));u.appendChild(i);t=sj_ce("input","fbpgdgal","hlig");t.type="text";t.placeholder=this.GetLocString("DIALOG_ALIAS_TEXT");t.name=this.aliasTxtName;t.setAttribute("data-err",this.GetLocString("DIALOG_ALIAS_ERROR_TEXT"));t.setAttribute("data-depends-on",h);t.required=!0;u.appendChild(t);s!=null&&s!=t.placeholder&&s!=t.getAttribute("data-err")&&(t.value=s);n.appendChild(u);sj_be(r,"click",function(){r.checked?t.removeAttribute("disabled"):(t.setAttribute("disabled","true"),Lib.CssClass.remove(t,"error"),t.value==t.getAttribute("data-err")&&(t.value=""));Lib.CssClass.toggle(o,"disabled");Lib.CssClass.toggle(e,"disabled")});Feedback.Core.EnableValidation(u,!1)},t.prototype.ResetShowForm=function(){for(var u,n=_ge(this.feedbackContainerId),f=this.GetCategoryRadioButtons(n),e=n.querySelector('input[name="screenshot"]'),o=n.querySelector('input[name="sendmail"]'),t=n.querySelector('input[name="alias"]'),r=this.GetAlias(),i=0,s=f.length;i<s;i++)f[i].checked=i==this.selectedByDefaultCatIdx?!0:!1;u=_ge(Feedback.Core.verbatimTxtId);u.value="";Lib.CssClass.remove(u,"error");e&&(e.checked=!0);o&&(o.checked=!0,Lib.CssClass.remove(n.querySelector('label[for="fbpgdgal"]'),"disabled"),Lib.CssClass.remove(n.querySelector('label[for="fbpgdgml"]'),"disabled"),t.removeAttribute("disabled"));t&&(t.value=r&&r!=t.placeholder?r:"",Lib.CssClass.remove(t,"error"));_ge(this.modalShieldId).style.display="block";_ge(this.feedbackContainerId).style.display="block"},t.prototype.HideForm=function(){_ge(this.feedbackContainerId).style.display="none";_ge(this.modalShieldId).style.display="none"},t.prototype.RemoveForm=function(){Feedback.Core.Remove(_ge(this.feedbackContainerId));Feedback.Core.Remove(_ge(this.modalShieldId))},t.prototype.AddLabeledInputSdk=function(n,t,i,r,u,f,e,o,s,h){var l,c,a;return r===void 0&&(r=undefined),u===void 0&&(u=undefined),f===void 0&&(f=undefined),e===void 0&&(e="inputwrapper"),o===void 0&&(o=null),s===void 0&&(s=null),h===void 0&&(h=null),l=sj_ce("div",null,e),c=sj_ce("input",h,o),c.type=t,u===!0&&(c.checked=!0),typeof r=="string"&&(c.name=r),typeof f=="string"&&(c.value=f),l.appendChild(c),a=sj_ce("label",null,s),a.setAttribute("for",h),a.appendChild(_d.createTextNode(i)),l.appendChild(a),n.appendChild(l),c},t}(n.WindowsFeedbackFormBase);_w.WindowsFeedbackForm=new t}(WindowsFeedback||(WindowsFeedback={})),function(n){var t;(function(t){"use strict";function u(){typeof SearchAppWrapper!="undefined"&&SearchAppWrapper.CortanaApp&&SearchAppWrapper.CortanaApp.setChromeState&&SearchAppWrapper.CortanaApp.setChromeState(7);r=n.Core.GetComputedStyle(_d.documentElement)["overflow-y"];_d.documentElement.style["overflow-y"]="hidden";i=!0}function f(){if(i){if(typeof SearchAppWrapper!="undefined"&&SearchAppWrapper.CortanaApp){SearchAppWrapper.CortanaApp.restorePreviousChromeState&&SearchAppWrapper.CortanaApp.restorePreviousChromeState();SearchAppWrapper.CortanaApp.closeFeedbackPage&&SearchAppWrapper.CortanaApp.closeFeedbackPage();var n=_w.feedback&&_w.feedback.config&&_w.feedback.config.focusCortanaSearchBoxOnFeedbackClosed;n&&SearchAppWrapper.CortanaApp.searchBox&&SearchAppWrapper.CortanaApp.searchBox.requestFocus&&SearchAppWrapper.CortanaApp.searchBox.requestFocus()}_d.documentElement.style["overflow-y"]=r;i=!1}}var r,i=!1;t.SetForFeedback=u;t.Reset=f})(t=n.CortanaState||(n.CortanaState={}))}(Feedback||(Feedback={}))