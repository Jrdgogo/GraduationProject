(function (doc, win) {
            var docEl = doc.documentElement,
                resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
                recalc = function () {
                    var clientWidth = docEl.clientWidth;
                    if (!clientWidth) return;
                    if(clientWidth>=600){
                        docEl.style.fontSize = 100 * (clientWidth / 600) + 'px';
                    }else{
                        docEl.style.fontSize = '100px';
                    }
                };

                if (!doc.addEventListener) return;
                win.addEventListener(resizeEvt, recalc, false);
                doc.addEventListener('DOMContentLoaded', recalc, false);
            })(document, window);
                          // 自适应的问题 js写的
